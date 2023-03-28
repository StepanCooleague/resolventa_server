package com.staple.resolventa.solvers;

import com.staple.resolventa.prosol.Problem;
import com.staple.resolventa.prosol.Solution;

public interface Solver {
    Solution solve(Problem problem);
}
