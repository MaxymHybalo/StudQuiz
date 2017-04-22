package ua.chstu.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    private static final Logger log = LoggerFactory.getLogger(QuizController.class);

    @PostMapping("/results")
    public QuizResults computeResults(
            @RequestBody QuizResultProjection projection) {
        log.warn("User id : " + projection.getUser());
        QuizResults quizResults = service.makeResults(projection);
        if(projection.getUser() != null){
            quizResults.setUserId(projection.getUser());
            quizResults.setParams(projection.getParams());
            service.save(quizResults);
        }
        quizResults.setParams(null); //to optimise response weight
        return quizResults;
    }
}
