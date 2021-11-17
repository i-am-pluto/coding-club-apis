package com.codingclubwebsite.codingclub.problem;

import javax.persistence.*;

@Entity
public class Problem {
    @Id
    private String problemId;

    @Lob
    private String statement;
    private String title;

    private int  sno;
    private int diff;
    private int submissions;
    private int timeLimit;
    public Problem(){

    }
    public Problem(String problemId,String statement,int sno,int diff,int submissions,int timeLimit){
        this.diff=diff;
        this.sno=sno;
        this.statement=statement;
        this.problemId=problemId;
        this.submissions=submissions;
        this.timeLimit=timeLimit;
    }


    public int getSubmissions() {
        return submissions;
    }

    public int getDiff() {
        return diff;
    }

    public int getSno() {
        return sno;
    }

    public String getProblemId() {
        return problemId;
    }

    public String getStatement() {
        return statement;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }


    public void setDiff(int diff) {
        this.diff = diff;
    }

    public void setProblemId(String problemId) {
        this.problemId = problemId;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public void setSubmissions(int submissions) {
        this.submissions = submissions;
    }
}

