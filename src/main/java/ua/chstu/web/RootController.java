package ua.chstu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.chstu.data.domain.Category;
import ua.chstu.data.domain.QCase;
import ua.chstu.data.domain.Subject;
import ua.chstu.data.repositories.CategoriesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller()
public class RootController {

    @PostMapping("/login")
    @ResponseBody
    public String login(){
        return "OK";
    }


    @PostMapping("/logout")
    @ResponseBody
    public String logout(){
        return "OK";
    }

    @Autowired CategoriesRepository repository;

    @PostMapping("/trigger")
    @ResponseBody
    public Map trigger(@RequestBody Map<String, Boolean> test){
        System.out.println(test.toString());
        return test;
    }

    @Autowired MongoOperations mongoOps;

}
