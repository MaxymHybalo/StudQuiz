package ua.chstu.data.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import ua.chstu.data.domain.Category;
import ua.chstu.data.services.BaseService;

import java.util.List;

@Service
public class CategoryService implements BaseService{

    @Autowired
    private MongoOperations ops;

    public  List<Category> findCategoryNames(){
        Query query = new Query();
        query.fields().include("name").include("_id");
        return ops.find(query, Category.class);
    }

    public Category findById(String id){
        Query query = Query.query(Criteria.where("_id").is(id));
        return ops.findById(id, Category.class);
    }

    @Override
    public List<Category> all() {
        return ops.findAll(Category.class);
    }


    @Override
    public <T> void save(T t) {
        Category category = (Category) t;
        ops.save(category);
        System.out.println("Category saved...");
    }
}