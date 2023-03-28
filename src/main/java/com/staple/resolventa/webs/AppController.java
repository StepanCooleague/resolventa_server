package com.staple.resolventa.webs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.staple.resolventa.prosol.Problem;
import com.staple.resolventa.prosol.Solution;
import com.staple.resolventa.solvers.Solver;
import com.staple.resolventa.solvers.SolverFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @PostMapping("/process")
    public ResponseEntity<String> processData(@RequestBody String data) {
//        // Ваш код для обработки данных
//        System.out.println("Получены данные: " + data);
//        return new ResponseEntity<>("Данные успешно обработаны", HttpStatus.OK);

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Problem problem = gson.fromJson(data, Problem.class);

        SolverFactory sf = new SolverFactory();
        Solver solver = sf.createSolver(problem);

        Solution solution = solver.solve(problem);
        String result = gson.toJson(solution);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
