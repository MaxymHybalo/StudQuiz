package ua.chstu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.chstu.data.domain.QuizResults;
import ua.chstu.data.domain.projection.Params;
import ua.chstu.data.domain.projection.QuizResultProjection;
import ua.chstu.data.services.impl.QuizService;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService service;

    @PostMapping("/results")
    public QuizResults computeResults(@RequestBody QuizResultProjection projection) {
        QuizResults quizResults = service.makeResults(projection);
        quizResults.setParams(projection.getParams());
        service.save(quizResults);
        quizResults.setParams(null); //to optimise response weight
        return quizResults;
    }
}
