package com.codingclubwebsite.codingclub.problem.examples;

import javax.persistence.*;

@Entity
public class Example {
    @Id
    private String exampleId;
    private String input;
    private String output;
    private String problemId;
    public Example(){

    }
    public Example(String exampleId, String input, String output, String problemId) {
        this.exampleId = exampleId;
        this.input = input;
        this.output = output;
        this.problemId = problemId;
    }

    public String getProblemId() {
        return problemId;
    }

    public void setProblemId(String problemId) {
        this.problemId = problemId;
    }
    public String getExampleId() {
        return exampleId;
    }

    public void setExampleId(String exampleId) {
        this.exampleId = exampleId;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
