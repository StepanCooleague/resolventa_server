package com.staple.resolventa.solvers;

import com.staple.resolventa.execruns.ExecFileRunner;
import com.staple.resolventa.execruns.NotZeroExitCodeException;
import com.staple.resolventa.prosol.Problem;
import com.staple.resolventa.prosol.Solution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NaturalSequentSolver implements Solver{
    private static final String ERROR_TYPE = "error_type";
    @Override
    public Solution solve(Problem problem) {
        Solution res;

        List<String> command = new ArrayList<>();
        command.add("./raw/wang");
        command.add("-s");
        command.add(problem.problem_content);
        command.add("-b");
        command.add("LaTeX");

        ExecFileRunner runner = new ExecFileRunner(command);

        try {
            res = new Solution(problem.problem_type, runner.Run());
        } catch (IOException | InterruptedException | NotZeroExitCodeException e) {
            res = new Solution(ERROR_TYPE, e.getMessage());
        }

        return res;
    }
}
