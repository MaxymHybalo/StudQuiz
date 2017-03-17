package ua.chstu.data.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import ua.chstu.data.domain.Category;
import ua.chstu.data.domain.Subject;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectService {

    @Autowired
    private MongoOperations ops;

    public Subject findByIdAndName(String id, String name){
        Category category = ops.findById(id, Category.class);
        List<Subject> subjects = category.getSubjects()
                .stream()
                .filter(e -> e.getName().equals(name))
                .collect(Collectors.toList());

        return subjects.get(0);
    }

}
