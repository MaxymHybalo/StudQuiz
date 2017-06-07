package ua.chstu.data.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import ua.chstu.data.domain.Question;
import ua.chstu.data.domain.QuizResults;
import ua.chstu.data.domain.projection.Params;
import ua.chstu.data.domain.projection.QuizResultProjection;
import ua.chstu.data.services.BaseService;
import ua.chstu.utils.QuizResultsBuilder;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class QuizService implements BaseService{

    private static final Logger log = LoggerFactory.getLogger(QuizService.class);

    @Autowired
    private MongoOperations ops;

    @Autowired
    private QuestionService questionService;

    public QuizResults makeResults(QuizResultProjection projection){
        Set<Question> testedCase = questionService.findInSubject(projection.getParams());
        log.info("QCase to compare " + testedCase.toString());
        QuizResultsBuilder builder = new QuizResultsBuilder(testedCase, projection.getData());
        return builder.build();
    }

    public Map<Params,QuizResults> findByContestant(String id){
        Query query = Query.query(Criteria.where("userId").is(id));
        return QuizResultsBuilder.filterRecentResults(ops.find(query, QuizResults.class));
    }
    @Override
    public List<QuizResults> all() {
        return ops.findAll(QuizResults.class);
    }


    @Override
    public <T> void save(T t) {
        QuizResults results = (QuizResults) t;
        ops.save(results);
    }

}
