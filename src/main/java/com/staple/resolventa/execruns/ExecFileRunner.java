package com.staple.resolventa.execruns;

import java.io.*;
import java.util.List;

public class ExecFileRunner {
    final private List<String> command;

    public ExecFileRunner(List<String> command) {
        this.command = command;
    }

    public String Run() throws IOException, InterruptedException, NotZeroExitCodeException {
        String res;
        ProcessBuilder pb = new ProcessBuilder(command);

        Process process = pb.start();

        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder resBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            resBuilder.append(line).append("\n");
        }
        res = resBuilder.toString();

        int exitCode = process.waitFor();
        if(exitCode != 0)
            throw new NotZeroExitCodeException("Something is wrong with your input data or server executable...");

        return res;
    }
}

