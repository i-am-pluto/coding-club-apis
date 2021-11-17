package com.codingclubwebsite.codingclub.submission;

import com.codingclubwebsite.codingclub.problem.Problem;
import com.codingclubwebsite.codingclub.problem.ProblemRepository;
import com.codingclubwebsite.codingclub.responses.PostRequestResponse;
import com.codingclubwebsite.codingclub.submission.CodeJudge.FinalResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin("http://localhost:3000")
public class SubmissionController {

    @Autowired
    private SubmissionRepository submissionRepository;
    @Autowired
    private ProblemRepository problemRepository;

    @PostMapping("/{problemId}/submission")
    public  PostRequestResponse addSubmission(@RequestBody SubmissionEntity submission, @PathVariable String problemId){

        try {
            submissionRepository.save(submission);
            Problem problem = problemRepository.findById(problemId).get();
            problem.setSubmissions(problem.getSubmissions()+1);
            problemRepository.save(problem);
            this.execute(submission);
            return new PostRequestResponse("Submission Successful", submission.getSubmissionID(), "The code Was Successfully submitted");
        }
        catch (Exception e){
            return new PostRequestResponse("Code Submission Failed", submission.getSubmissionID(), "The code submission failed :- "+e.getMessage());
        }
    }
    
    private void execute(SubmissionEntity submission) throws IOException, InterruptedException {
        // execute the code
        Executable executable = new Executable(submission.getLanguage(), submission.getCode(), submission);
        FinalResult finalResult = executable.codeJudge();
        submission.setCompiled(finalResult.isCompiled());
        submission.setUserFailedOutput(finalResult.getFailedOutput());
        submission.setFailedTestCaseCorrectInput(finalResult.getFailedTestCase().getInput());
        submission.setNumberOfTestCase(finalResult.getNumberOfTestCase());
        submission.setError(finalResult.getError());
        submission.setPending(false);
        submission.setNumberOfTestcasePassed(finalResult.getNumberOfTestcasePassed());
        submissionRepository.save(submission);
    }
}
