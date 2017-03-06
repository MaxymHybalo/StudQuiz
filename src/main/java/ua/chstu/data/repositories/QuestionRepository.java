package ua.chstu.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.chstu.data.domain.Question;

public interface  QuestionRepository extends MongoRepository<Question,String> {
}
