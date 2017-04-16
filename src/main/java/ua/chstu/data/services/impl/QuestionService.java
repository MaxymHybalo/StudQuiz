package ua.chstu.data.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.chstu.data.domain.Category;
import ua.chstu.data.domain.QCase;
import ua.chstu.data.domain.Question;
import ua.chstu.data.domain.Subject;
import ua.chstu.data.domain.projection.Params;
import ua.chstu.data.domain.projection.QCaseProjection;
import ua.chstu.data.repositories.QuestionRepository;
import ua.chstu.data.services.BaseService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Transactional
@Service
public class QuestionService {

    private static final Logger log = LoggerFactory.getLogger(QuestionService.class);

    @Autowired
    private MongoOperations ops;

    public Question addToCase(QCaseProjection projection){
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
        Subject subject = updateCurrentSubject(projection,getCurrentSubject(projection, subjects));

        subjects.forEach(e ->{
            if(e.getName().equals(projection.getParams().getName())){
                e = subject;
            }
        });

        category.setSubjects(subjects); //update Subject object in Category
        ops.save(category);
        log.info("Saved " + category.getName());
        return projection.getData();
    }

    public Set<Question> findInSubject(Params params){
        Query query = Query.query(Criteria
                .where("_id")
                .is(params.getCategory())
        .and("subjects.name").is(params.getName()));

        Category category = ops.findOne(query, Category.class);
        Set<Question> questions = getQuestionsByCredentials(params, category); //filtered necessary questions
        log.info(questions.toString());
        return questions;
    }


    private Set<Question> getQuestionsByCredentials(Params params, Category category) {
        return category
                    .getSubjects()
                    .stream()
                    .filter(e ->e.getName().equals(params.getName()))
                    .collect(Collectors.toList())
                    .get(0)
                    .getQuestionCases()
                    .stream()
                    .filter(e -> e.getName().equals(params.getQuestionCase()))
                    .collect(Collectors.toList())
                    .get(0)
                    .getQuestions();
    }

    private Subject updateCurrentSubject(QCaseProjection projection, Subject subject) {
        subject.getQuestionCases().forEach(e ->{
            if(e.getName().equals(projection.getParams().getQuestionCase())){
                if(e.getQuestions() == null){
                    e.setQuestions(new HashSet<>());
                }
                e.getQuestions().add(projection.getData());
            }
        });

        return subject;
    }

    private Subject getCurrentSubject(QCaseProjection projection, List<Subject> subjects) {
        return subjects
                .stream()
                .filter(e -> e.getName()
                        .equals(projection
                                .getParams()
                                .getName()))
                .collect(Collectors.toList()).get(0);
    }
}
