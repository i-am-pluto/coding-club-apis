package com.codingclubwebsite.codingclub.problem;

import com.codingclubwebsite.codingclub.problem.examples.Example;
import com.codingclubwebsite.codingclub.problem.testCases.TestCase;

import java.util.ArrayList;
import java.util.List;

public class ProblemTemplate {

   private List<Example> examples;
   private List<TestCase> testCases;
   private String problemId;
   private String statement;
   private int sno;
   private int diff;
   private int submissions;
   private int timeLimit;
   
   public ProblemTemplate( String problemId, String statement, int sno, int diff, int submissions,List<Example> examples, List<TestCase> testCases,int timeLimit) {
      this.examples = examples;
      this.testCases = testCases;
      this.problemId = problemId;
      this.statement = statement;
      this.sno = sno;
      this.diff = diff;
      this.submissions = submissions;
      this.timeLimit=timeLimit;
   }


   public int getTimeLimit() {
      return timeLimit;
   }

   public void setTimeLimit(int timeLimit) {
      this.timeLimit = timeLimit;
   }

   public List<Example> getExamples() {
      return examples;
   }

   public void setExamples(ArrayList<Example> examples) {
      this.examples = examples;
   }

   public List<TestCase> getTestCases() {
      return testCases;
   }

   public void setTestCases(ArrayList<TestCase> testCases) {
      this.testCases = testCases;
   }

   public String getProblemId() {
      return problemId;
   }

   public void setProblemId(String problemId) {
      this.problemId = problemId;
   }

   public String getStatement() {
      return statement;
   }

   public void setStatement(String statement) {
      this.statement = statement;
   }

   public int getSno() {
      return sno;
   }

   public void setSno(int sno) {
      this.sno = sno;
   }

   public int getDiff() {
      return diff;
   }

   public void setDiff(int diff) {
      this.diff = diff;
   }

   public int getSubmissions() {
      return submissions;
   }

   public void setSubmissions(int submissions) {
      this.submissions = submissions;
   }
}
