import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class pb {

    public static void main(String[] args) throws IOException, InterruptedException {

        String code = "#include<iostream>\nusing namespace std;\nint main(){\n\tint x;\n\tcin>>x;\n\tcout<<\"Hello World\"<<endl;\n\treturn 0;\n}";

        String path = "new/" + "313wwqek112";
        File dir = new File(path);

        if (!dir.mkdir()) {
            // server-side error
            System.out.println("Error");
        }

        // generate the code file inside the temp files folder
        String fileName = path + "/code.cpp";

        File codeFile = new File(fileName);

        try {
            codeFile.createNewFile();
            FileWriter codeWriter = new FileWriter(fileName);
            codeWriter.write(code);
            codeWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String commands = "cd " + path + "\n" + "g++ -lm code.cpp 2>err.txt";

        // works fine
        fileName = path + "/compile.sh";

        codeFile = new File(fileName);

        try {
            codeFile.createNewFile();
            FileWriter codeWriter = new FileWriter(fileName);
            codeWriter.write(commands);
            codeWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("chmod +x " + path + "/compile.sh");
        try {
            process.waitFor();
            process = runtime.exec(path + "/compile.sh");
            process.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // check if there was an error in the compilation
        File errFile = new File(path + "/err.txt");
        if (errFile.length() != 0) {
            // return error
            System.out.println("There was an error");
            return;
        }
        // execute the code

        // make an in.txt file

        String inFile = path + "/in.txt";
        File input = new File(inFile);

        try {
            input.createNewFile();
            FileWriter inputWriter = new FileWriter(inFile);
            inputWriter.write("123456");
            inputWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileWriter execWriter = new FileWriter(path + "/run.sh");
        execWriter.write("cd \"" + path + "\"\n");
        execWriter.write("chroot .\n");
        execWriter.write("./a.out < in.txt > out.txt");
        execWriter.close();
        Runtime run = Runtime.getRuntime();
        Process codeRunner = run.exec("chmod +x " + path + "/run.sh");
        codeRunner.waitFor();
        codeRunner = run.exec(path + "/run.sh");
        codeRunner.waitFor(3, TimeUnit.SECONDS);

        if (codeRunner.isAlive()) {
            codeRunner.destroy();
            // send TLE
        }
        // math the output from the ideal output
        ArrayList<String> output = new ArrayList<>();
        File outFile = new File(path + "/out.txt");
        BufferedReader outReader = new BufferedReader(new FileReader(outFile));
        String temp;
        while ((temp = outReader.readLine()) != null) {
            output.add(temp);
        }
        outReader.close();
        int count = 0;
        String failedOutput = "";
        String userOutput = "";
        int index = 0;
        ArrayList<String> idealOutput = new ArrayList<>();
        idealOutput.add("123456");
        for (int i = 0; i < idealOutput.size(); i++) {
            if (idealOutput.get(i) != output.get(i)) {
                // output doesnot match
                count++;
                failedOutput = idealOutput.get(i);
                userOutput = output.get(i);
                index = i + 1;
            }
        }
        System.out.println("naacho bhayi");
        System.out.println(failedOutput + " " + userOutput + " " + index);
    }
}