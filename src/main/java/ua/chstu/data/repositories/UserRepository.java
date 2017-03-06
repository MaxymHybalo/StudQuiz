package ua.chstu.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.chstu.data.domain.User;

public interface UserRepository  extends MongoRepository<User,String>{
    User findUserByLogin(String login);
}
