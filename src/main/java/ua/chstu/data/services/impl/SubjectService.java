package ua.chstu.data.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import ua.chstu.data.domain.Category;
import ua.chstu.data.domain.Subject;
import ua.chstu.data.domain.projection.SubjectProjection;

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

    public Category update(SubjectProjection projection){
        //rebuild
//        Query query = Query.query(Criteria.where("subjects.name").is("Subject2"));
        Query query = Query.query(Criteria
                .where("_id")
                .is(projection
                        .getParams()
                        .getCategory())
                .and("subjects.name")
                .is(projection
                        .getParams()
                        .getName()));
        Category category = ops.findOne(query, Category.class);
        List<Subject> subjects = category.getSubjects();
        subjects.forEach(e -> {
            if(e.getName().equals(projection.getData().getName())){
                e.setQuestionCases(projection.getData().getQuestionCases());
            }
        });
        category.setSubjects(subjects);
        ops.save(category);
        return ops.findOne(query, Category.class);
    }

}
