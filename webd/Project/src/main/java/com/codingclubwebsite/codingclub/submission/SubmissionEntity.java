package com.codingclubwebsite.codingclub.submission;

import com.codingclubwebsite.codingclub.problem.testCases.TestCase;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SubmissionEntity {
    @Id
    private String submissionID;
    private String problemID;
    private String submissionStatus;
    private String userId;
    private String language;
    private String code;
    private boolean pending;
    private int numberOfTestcasePassed;
    private boolean isCompiled;
    private String error;
    private int numberOfTestCase;
    private String failedTestCaseCorrectInput;
    private String failedTestCaseCorrectOutput;
    private String userFailedOutput;

    public SubmissionEntity(){

    }

    public SubmissionEntity(String submissionID, String problemID, String submissionStatus, String userId, String language, String code, boolean pending, int numberOfTestcasePassed, boolean isCompiled, String error, int numberOfTestCase, String failedTestCaseCorrectInput, String failedTestCaseCorrectOutput, String userFailedOutput) {

        this.submissionID = submissionID;
        this.problemID = problemID;
        this.submissionStatus = submissionStatus;
        this.userId = userId;
        this.language = language;
        this.code = code;
        this.pending = pending;
        this.numberOfTestcasePassed = numberOfTestcasePassed;
        this.isCompiled = isCompiled;
        this.error = error;
        this.numberOfTestCase = numberOfTestCase;
        this.failedTestCaseCorrectInput = failedTestCaseCorrectInput;
        this.failedTestCaseCorrectOutput = failedTestCaseCorrectOutput;
        this.userFailedOutput = userFailedOutput;

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

    public String getFailedTestCaseCorrectInput() {
        return failedTestCaseCorrectInput;
    }

    public void setFailedTestCaseCorrectInput(String failedTestCaseCorrectInput) {
        this.failedTestCaseCorrectInput = failedTestCaseCorrectInput;
    }

    public String getFailedTestCaseCorrectOutput() {
        return failedTestCaseCorrectOutput;
    }

    public void setFailedTestCaseCorrectOutput(String failedTestCaseCorrectOutput) {
        this.failedTestCaseCorrectOutput = failedTestCaseCorrectOutput;
    }

    public String getUserFailedOutput() {
        return userFailedOutput;
    }

    public void setUserFailedOutput(String userFailedOutput) {
        this.userFailedOutput = userFailedOutput;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }





    public String getSubmissionStatus() {
        return submissionStatus;
    }

    public void setSubmissionStatus(String submissionStatus) {
        this.submissionStatus = submissionStatus;
    }

    public String getSubmissionID() {
        return submissionID;
    }

    public void setSubmissionID(String submissionID) {
        this.submissionID = submissionID;
    }

    public String getProblemID() {
        return problemID;
    }

    public void setProblemID(String problemID) {
        this.problemID = problemID;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
