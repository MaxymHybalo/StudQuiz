package ua.chstu.data.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.chstu.data.domain.Question;
import ua.chstu.data.domain.Subject;
import ua.chstu.data.repositories.QuestionRepository;
import ua.chstu.data.services.BaseService;

import java.util.List;

@Transactional
@Service
public class QuestionService implements BaseService {

    @Autowired
    private SubjectService service;

    @Override
    public List<Question> all() {
        return null;
    }

    @Override
    public <T> void save(T t) {
        Question question = (Question) t;
    }
}
