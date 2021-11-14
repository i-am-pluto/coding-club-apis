package com.codingclubwebsite.codingclub.problem.testCases;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TestCase {
    @Id
    private String testCaseId;
    private String Input;
    private String Output;
    private String problemId;
    public TestCase(){

    }

    public  TestCase(String testCaseId, String input , String output,String problemId){
        this.testCaseId = testCaseId;
        this.Input=Input;
        this.Output= Output;
        this.problemId=problemId;
    }

    public String getProblemId() {
        return problemId;
    }

    public void setProblemId(String problemId) {
        this.problemId = problemId;
    }

    public String getInput() {
        return Input;
    }

    public String getOutput() {
        return Output;
    }

    public String getTestCaseId() {
        return testCaseId;
    }

    public void setInput(String input) {
        Input = input;
    }

    public void setOutput(String output) {
        Output = output;
    }

    public void setTestCaseId(String testCasesId) {
        this.testCaseId = testCasesId;
    }
}
