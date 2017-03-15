package ua.chstu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.chstu.data.domain.Category;
import ua.chstu.data.domain.QCase;
import ua.chstu.data.domain.Subject;
import ua.chstu.data.repositories.CategoriesRepository;

import java.util.ArrayList;
import java.util.List;

@Controller()
public class RootController {

    @PostMapping("/login")
    @ResponseBody
    public String login(){
        return "OK";
    }

    @GetMapping("/login")
    @ResponseBody
    public String getLogin(){
        return "" +
                "<form action='/login' method='post'>" +
                "<input type='text' name='username' />" +
                "<input type='text' name='password'/>" +
                "<input type='submit'/></form>";
    }


    @PostMapping("/logout")
    @ResponseBody
    public String logout(){
        return "OK";
    }

    @Autowired CategoriesRepository repository;

    @GetMapping("/trigger")
    @ResponseBody
    public Category trigger(){
//        List<QCase> cases = new ArrayList<>();
//        cases.add(new QCase("testCase"));
//        cases.add(new QCase("testCase1"));
//        cases.add(new QCase("testCase2"));
//
//        List<Subject> subjects = new ArrayList<>();
//        subjects.add(new Subject("testSubj1", cases));
//        subjects.add(new Subject("testSubj2", null));

        Category category = new Category("category2", null);

        repository.save(category);

        return category;
    }

    @Autowired MongoOperations mongoOps;

    @GetMapping("/test")
    @ResponseBody
    public Category names(){
        List<QCase> cases = new ArrayList<>();
        cases.add(new QCase("test1"));
        cases.add(new QCase("test2"));
        cases.add(new QCase("test3"));

        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject("testSubj3", cases));
//        subjects.add(new Subject("testSubj4", null));

        Query query = Query.query(Criteria.where("name").is("category2"));
        Update update = new Update();
        update.set("subjects",subjects);

        Category category = mongoOps.findOne(query,Category.class);
        mongoOps.updateFirst(query,update, Category.class);
//        List<Category> resource = mongoOps.findAll(Category.class);
        return category;
    }
}
