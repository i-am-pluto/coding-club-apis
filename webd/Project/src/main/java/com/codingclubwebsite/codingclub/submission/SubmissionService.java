package com.codingclubwebsite.codingclub.submission;

import com.codingclubwebsite.codingclub.problem.Problem;
import com.codingclubwebsite.codingclub.problem.ProblemRepository;
import com.codingclubwebsite.codingclub.problem.testCases.TestCase;
import com.codingclubwebsite.codingclub.problem.testCases.TestCaseRepository;
import com.codingclubwebsite.codingclub.responses.PostRequestResponse;
import com.codingclubwebsite.codingclub.submission.CodeJudge.FinalResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SubmissionService {

    @Autowired
    private ProblemRepository problemRepository;

    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private TestCaseRepository testCaseRepository;

    public PostRequestResponse submissionMade(SubmissionEntity submission){
        submission.setSubmissionStatus("Accepted");
        submissionRepository.save(submission);
        // call the execution for the submission

        // implement this asynchronously
        this.execute(submission);
        return new PostRequestResponse("Submission Made Successfully", submission.getSubmissionId(),"The submission was made successfully u will get your results in a moment");
    }


    private void execute(SubmissionEntity submission){

        String lang = submission.getLanguage();
        String code = submission.getCode();
        Problem problem = problemRepository.findById(submission.getProblemId()).get();
        problem.setSubmissions(problem.getSubmissions()+1);
        problemRepository.save(problem);
        List<TestCase>testCases = testCaseRepository.findAllByProblemId(submission.getProblemId());
        Executable executor = new Executable(testCases,submission,problem.getTimeLimit(),lang,code);

        FinalResult finalResult = null;
        try {
            finalResult = executor.codeJudge();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // make the updates
        if(finalResult==null){
            return;
        }

        submission.setCompiled(finalResult.isCompiled());
        submission.setUserFailedOutput(finalResult.getFailedOutput());
        submission.setNumberOfTestCase(finalResult.getNumberOfTestCase());
        submission.setError(finalResult.getError());
        submission.setPending(false);
        submission.setNumberOfTestcasePassed(finalResult.getNumberOfTestcasePassed());

        if(finalResult.getFailedTestCase()==null){
            System.out.println("hi");
            submissionRepository.save(submission);
            return;
        }
        String corrInput  =finalResult.getFailedTestCase().getInput();
        submission.setFailedTestCaseCorrectInput(corrInput);
        submission.setFailedTestCaseCorrectOutput(finalResult.getFailedTestCase().getOutput());
        submissionRepository.save(submission);

        return;
    }

    public SubmissionEntity getSubmission(String id){
        SubmissionEntity  s = submissionRepository.findById(id).get();
        return s;
    }

}
