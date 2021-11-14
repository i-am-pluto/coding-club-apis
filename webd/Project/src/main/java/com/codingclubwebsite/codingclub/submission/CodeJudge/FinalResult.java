package com.codingclubwebsite.codingclub.submission.CodeJudge;

import com.codingclubwebsite.codingclub.problem.testCases.TestCase;

public class FinalResult {
    private int numberOfTestcasePassed;
    private boolean isCompiled;
    private String error;
    private int numberOfTestCase;
    private TestCase failedTestCase;
    private String failedOutput;
    public FinalResult(){

    }

    public FinalResult(int numberOfTestcasePassed, boolean isCompiled, String error, int numberOfTestCase, TestCase failedTestCase, String failedOutput) {
        this.numberOfTestcasePassed = numberOfTestcasePassed;
        this.isCompiled = isCompiled;
        this.error = error;
        this.numberOfTestCase = numberOfTestCase;
        this.failedTestCase = failedTestCase;
        this.failedOutput = failedOutput;
    }

    public int getNumberOfTestcasePassed() {
        return numberOfTestcasePassed;
    }

    public void setNumberOfTestcasePassed(int numberOfTestcasePassed) {
        this.numberOfTestcasePassed = numberOfTestcasePassed;
    }

    public boolean isCompiled() {
        return isCompiled;
    }

    public void setCompiled(boolean compiled) {
        isCompiled = compiled;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getNumberOfTestCase() {
        return numberOfTestCase;
    }

    public void setNumberOfTestCase(int numberOfTestCase) {
        this.numberOfTestCase = numberOfTestCase;
    }

    public TestCase getFailedTestCase() {
        return failedTestCase;
    }

    public void setFailedTestCase(TestCase failedTestCase) {
        this.failedTestCase = failedTestCase;
    }

    public String getFailedOutput() {
        return failedOutput;
    }

    public void setFailedOutput(String failedOutput) {
        this.failedOutput = failedOutput;
    }

}
