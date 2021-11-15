package com.codingclubwebsite.codingclub.submission.CodeJudge;

import com.codingclubwebsite.codingclub.problem.testCases.TestCase;

import java.io.IOException;
import java.util.List;

public interface Executor {
    public FinalResult execute(String submissionId,int time , List<TestCase> testCaseList) throws IOException, InterruptedException;
    
}
