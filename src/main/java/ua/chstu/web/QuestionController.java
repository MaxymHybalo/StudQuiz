package ua.chstu.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.chstu.data.domain.Question;
import ua.chstu.data.domain.projection.Params;
import ua.chstu.data.domain.projection.QCaseProjection;
import ua.chstu.data.services.impl.QuestionService;

import java.util.List;
import java.util.Set;

@RestController()
@RequestMapping("question")
public class QuestionController {

    private static final Logger log = Logger.getLogger(QuestionController.class);

    @Autowired
    private QuestionService service;

    @PostMapping("/")
    public Question newQuestion(@RequestBody QCaseProjection projection){
        return service.addToCase(projection);
    }

    @GetMapping("/category/{id}/subject/{name}/case/{qcase}")
    public Set<Question> findInSubject(@PathVariable String id,
                                       @PathVariable String name,
                                       @PathVariable String qcase){
        Params params = new Params(id, name, qcase);
        log.info(params);
        return service.findInSubject(params);
    }
}
