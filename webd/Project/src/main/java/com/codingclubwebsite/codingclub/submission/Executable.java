package com.codingclubwebsite.codingclub.submission;

import com.codingclubwebsite.codingclub.problem.Problem;
import com.codingclubwebsite.codingclub.problem.ProblemRepository;
import com.codingclubwebsite.codingclub.problem.testCases.TestCase;
import com.codingclubwebsite.codingclub.problem.testCases.TestCaseRepository;
import com.codingclubwebsite.codingclub.submission.CodeJudge.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Executable {

    private List<TestCase> testCases;
    private  SubmissionEntity submission;
    private int timeLimit;
    private String lang;
    private String code;

    public Executable(List<TestCase> testCases, SubmissionEntity submission, int timeLimit, String lang, String code) {
        this.testCases = testCases;
        this.submission = submission;
        this.timeLimit = timeLimit;
        this.lang = lang;
        this.code = code;
    }

    public List<TestCase> getTestCases() {
        return testCases;
    }

    public void setTestCases(ArrayList<TestCase> testCases) {
        this.testCases = testCases;
    }

    public SubmissionEntity getSubmission() {
        return submission;
    }

    public void setSubmission(SubmissionEntity submission) {
        this.submission = submission;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public FinalResult codeJudge() throws IOException, InterruptedException {
        /*
        * Execute the code
        * Run the TestCases
        * Generate The output Files
        * Match with the text cases ideal result
        * Generate Final Result
        * Return the result
         */
        String path = "src/main/java/com/codingclubwebsite/codingclub/submission/CodeJudge/tempfiles/"+this.submission.getSubmissionId();
        File dir = new File(path);
        System.out.println(dir.getAbsolutePath());
        if(!dir.mkdir()){
            // server-side error
            System.out.println("Failed creating the files");
            return new FinalResult(0,false,"Server-side Error",0,null,null);
        }

        // generate the code file inside the temp files folder
        String fileName = path+"/code";
        switch(lang){
            case "cpp":
                fileName+=(".cpp");
                break;
            case "java":
                fileName+=(".java");
                break;
            case "python":
                fileName+=(".py");
                break;
        }

        File codeFile = new File(fileName);

        try {
            codeFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter codeWriter = new FileWriter(fileName);
            codeWriter.write(this.code);
            codeWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(this.submission.getProblemId());

        Executor executor = null;
        switch (lang){
            case "cpp":
                executor = new CppExecution();
                break;
            case "java":
                executor = new JavaExecution();
                break;
            case "python":
                executor = new PythonExecution();
                break;

        }

        FinalResult result = executor.execute(submission.getSubmissionId(),this.timeLimit,this.testCases);
        deleteDirectory(dir);
        return result;
    }

    private void deleteDirectory(File file) {

        for (File subFile : file.listFiles()) {

            if (subFile.isDirectory()) {
                deleteDirectory(subFile);
            }
            subFile.delete();
        }
        file.delete();
    }

}
