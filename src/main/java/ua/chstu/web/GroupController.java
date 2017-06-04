package ua.chstu.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.chstu.data.domain.study.Group;
import ua.chstu.data.domain.study.Student;
import ua.chstu.data.services.impl.GroupService;
import ua.chstu.web.security.SessionHolder;

import java.util.List;


@RestController
@RequestMapping("/group")
public class GroupController {

    private final static Logger log = Logger.getLogger(GroupController.class);
    @Autowired
    private SessionHolder holder;

    @Autowired
    private GroupService service;

    @PostMapping
    public List<Group> newGroup(@RequestBody Group group){
        log.info(group);
        group.setCreatorId(holder.authenticatedUser().getId());
        service.save(group);
        return service.all();
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return service.findByCreator(holder.authenticatedUser().getId());
    }

    @GetMapping("/students/{groupId}/")
    public List<Student> getStudentsByGroup(@PathVariable String groupId){
        log.info("Called for students by " + groupId);
        return service.findByGroupId(groupId);
    }

    @GetMapping
    public List<Group> getByAuthority(){
        return service.allByUser(holder.authenticatedUser());
    }
}
