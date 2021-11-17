package com.codingclubwebsite.codingclub.submission;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class SubmissionEntity {

    @Id
    private String submissionID;
    private String problemID;
    private String submissionStatus;
    private String userId;
    private String language;

    @Lob
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

    public SubmissionEntity(String submissionID, String problemID,String userId, String language, String code) {

        this.submissionID = submissionID;
        this.problemID = problemID;
        this.submissionStatus = "Pending";
        this.userId = userId;
        this.language = language;
        this.code = code;
        this.pending = true;
        this.numberOfTestcasePassed = 0;
        this.isCompiled = false;
        this.error = null;

        // to be passed

        this.numberOfTestCase = Integer.parseInt("");

        this.failedTestCaseCorrectInput = null;
        this.failedTestCaseCorrectOutput = null;
        this.userFailedOutput = null;

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
