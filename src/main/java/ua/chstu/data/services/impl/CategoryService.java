package ua.chstu.data.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import ua.chstu.data.domain.Category;
import ua.chstu.data.services.BaseService;

import java.util.List;

@Service
public class CategoryService implements BaseService{

    @Autowired
    private MongoOperations ops;

    @Override
    public List<CategoryService> all() {
        return null;
    }


    @Override
    public <T> void save(T t) {
        Category category = (Category) t;
        ops.save(category);
        System.out.println("Category saved...");
    }
}
