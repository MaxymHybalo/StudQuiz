package ua.chstu.data.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.chstu.data.domain.study.Group;
import ua.chstu.data.services.BaseService;

import java.util.List;

@Service
@Transactional
public class GroupService implements BaseService{

    @Autowired
    private MongoOperations ops;


    @Override
    public List<Group> all() {
        //add filling User objects
        return ops.findAll(Group.class);
    }

    @Override
    public <T> void save(T t) {
        Group group = (Group) t;
        ops.save(group);
    }

    public void update(Group group){
        Query query = Query.query(Criteria.where("_id").is(group.getId()));
        Update update = new Update();
        update.set("studentIds", group.getStudentIds());
        update.set("name", group.getName());
        ops.updateFirst(query,update,Group.class);
    }
}
