package ua.chstu.data.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.chstu.data.domain.User;
import ua.chstu.data.repositories.UserRepository;
import ua.chstu.data.services.BaseService;

import java.util.List;

@Transactional
@Service
public class UserService implements BaseService{

    @Autowired
    private UserRepository repository;

    public User byLogin(String login){
        User user = findByLogin(login);
        user.setLogin(null);
        user.setPassword(null);
        return user;
    }

    public User authenticatedByLogin(String login){
        return findByLogin(login);
    }

    private User findByLogin(String login){
        return repository.findUserByLogin(login);
    }

    @Override
    public List<User> all() {

        return repository.findAll();

    }

    @Override
    public <T> void save(T t) {

        User user = (User) t;
        repository.save(user);
        System.out.println(user.getId());

    }
}
