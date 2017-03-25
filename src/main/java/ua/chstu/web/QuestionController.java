package ua.chstu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.chstu.data.domain.Question;
import ua.chstu.data.domain.projection.QCaseProjection;
import ua.chstu.data.services.impl.QuestionService;

import java.util.List;

@RestController()
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService service;

    @PostMapping("/")
    public Question newQuestion(@RequestBody QCaseProjection projection){
        return service.addToCase(projection);
    }


}
