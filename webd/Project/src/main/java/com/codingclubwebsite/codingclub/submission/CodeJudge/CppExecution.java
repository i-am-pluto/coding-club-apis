package com.codingclubwebsite.codingclub.submission.CodeJudge;

import com.codingclubwebsite.codingclub.problem.testCases.TestCase;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CppExecution implements Executor {

    @Override
    public FinalResult execute(String submissionId, int time , List<TestCase> testCaseList) throws IOException, InterruptedException {
        /*
        * Find the code file
        * Build the command list
        * Process Builder
        * Run the commands
        * if error load the error statement
        * send the input
        * store the output
        * match the output
        * */
        String dirPath = "tempfiles/"+submissionId;
        String codeFilePath = "tempfiles/"+submissionId+"/"+"code.cpp";
        String commands = "cd " + dirPath + "\n" + "g++ -lm code.cpp 2>err.txt";

        File commandsFile = new File(dirPath+"/compile.sh");
        // comands file write
        commandsFile.createNewFile();
        FileWriter codeWriter = new FileWriter(dirPath+"/compile.sh");
        codeWriter.write(commands);
        codeWriter.close();

        //make it executable
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("chmod +x " + dirPath + "/compile.sh");
        process.waitFor();
        //execute it
        process = runtime.exec(dirPath + "/compile.sh");
        process.waitFor();

        //Read the errors
        File errFile = new File(dirPath + "/err.txt");
        if (errFile.length() != 0) {
            // return error
            //compilationError
            FinalResult compilationError = new FinalResult(0,false,"Compilation Error",testCaseList.size(),null,null);
            return compilationError;
        }

        //make the input.txt
        int count=1;
        for(TestCase testCase: testCaseList){

            String inFile = dirPath + "/in.txt";
            File input = new File(inFile);
            Files.deleteIfExists(Path.of(inFile));
            input.createNewFile();
            FileWriter inputWriter = new FileWriter(inFile);
            inputWriter.write(testCase.getInput()+"\n");
            inputWriter.close();

            // execute the code
            FileWriter execWriter = new FileWriter(dirPath + "/run.sh");
            execWriter.write("cd \"" + dirPath + "\"\n");
            execWriter.write("chroot .\n");
            execWriter.write("./a.out < in.txt > out.txt");
            execWriter.close();
            Runtime run = Runtime.getRuntime();
            Process codeRunner = run.exec("chmod +x " + dirPath + "/run.sh");
            codeRunner.waitFor();
            codeRunner = run.exec(dirPath + "/run.sh");
            codeRunner.waitFor(time, TimeUnit.SECONDS);

            if (codeRunner.isAlive()) {
                codeRunner.destroy();
                // send TLE
                FinalResult timeLimitError = new FinalResult(count,true,"Time Limit Error",testCaseList.size(),testCase,null);
                return timeLimitError;
            }

            String output = "";
            File outFile = new File(dirPath + "/out.txt");
            BufferedReader outReader = new BufferedReader(new FileReader(outFile));
            String temp;
            while ((temp = outReader.readLine()) != null) {
                output.concat(temp+"\n");
            }
            outReader.close();
            output=output.substring(0,output.length()-2);

            // match the outputs
            if(output != testCase.getOutput()){
                // testCaseFailed
                FinalResult testCaseFailed= new FinalResult(count,true,"TestCase Failed",testCaseList.size(),testCase,output);
                return testCaseFailed;
            }
            count++;
        }
        // if the code has reached here means all the test cases have passed. So we will give that the submission was accepted.
        FinalResult AcceptedSubmission = new FinalResult(testCaseList.size(),true,"Submission Accepted",testCaseList.size(),null,null);
        return AcceptedSubmission;

    }
}
