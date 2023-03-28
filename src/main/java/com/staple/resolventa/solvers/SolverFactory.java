package com.staple.resolventa.solvers;

import com.staple.resolventa.prosol.Problem;

public class SolverFactory {
    public Solver createSolver(Problem problem) {
        if (problem.problem_type.equals("natural_sequent_type")) {
            return new NaturalSequentSolver();
        }
        throw new IllegalArgumentException("Unsupported problem/solution type");
    }
}
