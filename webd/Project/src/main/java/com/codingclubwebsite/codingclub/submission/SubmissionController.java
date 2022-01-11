package com.codingclubwebsite.codingclub.submission;

import com.codingclubwebsite.codingclub.problem.Problem;
import com.codingclubwebsite.codingclub.problem.ProblemRepository;
import com.codingclubwebsite.codingclub.problem.testCases.TestCase;
import com.codingclubwebsite.codingclub.problem.testCases.TestCaseRepository;
import com.codingclubwebsite.codingclub.responses.PostRequestResponse;
import com.codingclubwebsite.codingclub.submission.CodeJudge.FinalResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@RestController
@CrossOrigin("http://localhost:3000")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;
    @Autowired
    private SubmissionRepository submissionRepository;

    @PostMapping("/{problemId}/submission")
    public  PostRequestResponse addSubmission(@RequestBody SubmissionEntity submission, @PathVariable String problemId) {

        return submissionService.submissionMade(submission);

    }

    @GetMapping("/submission/{submissionId}")
    public SubmissionEntity getSubmission(@PathVariable String submissionId){
        SubmissionEntity s = submissionRepository.findById(submissionId).get();
        return s;
    }

}
