package ua.chstu.data.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.chstu.data.domain.User;
import ua.chstu.data.domain.study.Group;
import ua.chstu.data.domain.study.Student;
import ua.chstu.data.services.BaseService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GroupService implements BaseService{

    @Autowired
    private MongoOperations ops;

    @Autowired
    private UserService service;


    @Override
    public List<Group> all() {
        //add filling User objects
        return ops.findAll(Group.class);
    }

    public List<Group> allByUser(User user){
        String id = user.getId();
        Query query = Query.query(Criteria.where("creatorId").is(id));
        return ops.find(query, Group.class);
    }

    public List<Student> findByCreator(String creatorId){
        Query query = Query.query(Criteria.where("creatorId").is(creatorId));
        List<Group> groups = ops.find(query, Group.class);
        return mapStudentsByCreator(groups);
    }

    public List<Student> findByGroupId(String groupId){
        Group group = ops.findById(groupId, Group.class);
        List<String> ids = group.getStudentIds();
        return ids.stream()
                .map(e-> service.find(e))
                .map(e-> new Student(
                        e.getFirst(),
                        e.getLast(),
                        e.getLogin(),
                        e.getPassword(),
                        e.getId()
                ))
                .collect(Collectors.toList());
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

    private List<Student> mapStudentsByCreator(List<Group> groups) {
        List<Student> students = new ArrayList<>();
        for (Group g: groups){
            for(String id: g.getStudentIds()){
                User user = ops.findById(id, User.class);
                // map to student
                students.add(new Student(
                        user.getFirst(),
                        user.getLast(),
                        user.getLogin(),
                        user.getPassword(),
                        user.getId(),
                        g.getName()));
            }
        }
        return students;
    }
}
