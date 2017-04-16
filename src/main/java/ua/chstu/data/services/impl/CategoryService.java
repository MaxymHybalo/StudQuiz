package ua.chstu.data.services.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import ua.chstu.data.domain.Category;
import ua.chstu.data.services.BaseService;

import java.util.List;

@Service
public class CategoryService implements BaseService{

    private static final Logger log = Logger.getLogger(CategoryService.class);

    @Autowired
    private MongoOperations ops;

    public  List<Category> findCategoryNames(){
        Query query = new Query();
        query.fields().include("name").include("_id");
        return ops.find(query, Category.class);
    }

    public Category findById(String id){
        return ops.findById(id, Category.class);
    }

    public Category update(Category category){
        Query query = Query.query(Criteria.where("_id").is(category.getId()));
        Update update = new Update();
        update.set("subjects", category.getSubjects());
        ops.updateFirst(query, update, Category.class);
        log.info("Updated " + category.toString());
        return category;
    }

    @Override
    public List<Category> all() {
        return ops.findAll(Category.class);
    }


    @Override
    public <T> void save(T t) {
        Category category = (Category) t;
        ops.save(category);
        log.info(category.getName() + " Saved!");
    }
}
