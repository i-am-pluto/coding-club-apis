package com.codingclubwebsite.codingclub.submission;

import com.codingclubwebsite.codingclub.problem.Problem;
import com.codingclubwebsite.codingclub.problem.ProblemRepository;
import com.codingclubwebsite.codingclub.problem.testCases.TestCase;
import com.codingclubwebsite.codingclub.problem.testCases.TestCaseRepository;
import com.codingclubwebsite.codingclub.submission.CodeJudge.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Executable {

    @Autowired
    private ProblemRepository problemRepository;
    @Autowired
    private TestCaseRepository testCaseRepository;

    private  SubmissionEntity submission;
    private String lang;
    private String code;

    public Executable(String lang, String code, SubmissionEntity submission) {
        this.lang = lang;
        this.code = code;
        this.submission = submission;
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
        String path = "/CodeJudge/tempfiles/"+this.submission.getSubmissionID();
        File dir = new File(path);

        if(!dir.mkdir()){
            // server-side error

        }

        // generate the code file inside the temp files folder
        String fileName = path+"/code";
        switch(lang){
            case "cpp":
                fileName.concat(".cpp");
                break;
            case "java":
                fileName.concat(".java");
                break;
            case "python":
                fileName.concat(".py");
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

        // load the problem's test-cases
        Problem problem = problemRepository.findById(this.submission.getProblemID()).get();

        ArrayList<TestCase>testCases = new ArrayList<>();
        for( TestCase testCase : testCaseRepository.findAllByProblemId(problem.getProblemId())){
            testCases.add(testCase);
        }

        // run the execution according to the input test cases according to the lang
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
        List<TestCase> testCaseList = testCaseRepository.findAllByProblemId(submission.getProblemID());
        FinalResult result = executor.execute(submission.getSubmissionID(),problem.getTimeLimit(),testCaseList);
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
    }

}
