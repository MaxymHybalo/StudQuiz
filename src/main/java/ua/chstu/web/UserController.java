package ua.chstu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.chstu.data.domain.User;
import ua.chstu.data.domain.study.Group;
import ua.chstu.data.domain.study.StudentProjection;
import ua.chstu.data.services.impl.GroupService;
import ua.chstu.data.services.impl.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("user")
public class UserController {

    private final String SIGN_UP_SUCCESS_MSG = "Ви успішно зареєструвалися!";

    @Autowired
    private UserService service;

    @Autowired
    private GroupService groupService;

    @PostMapping("/new")
    public String register(@RequestBody User user){
        System.out.println(user.toString());
        service.save(user);
        return SIGN_UP_SUCCESS_MSG;
    }

    @PostMapping("/student")
    public String addStudent(@RequestBody StudentProjection projection){
        //add login and password generation
        System.out.println(projection.getGroup().getId());
        User user = projection.getUser();
        user.setRole("STUDENT");
        user.setLogin(user.getLast());
        user.setPassword(user.getFirst() +(int) Math.floor(Math.random() * 100));
        System.out.println(user);
        service.save(user);
        groupService.update(updateGroup(projection));
        return user.getId(); //response user id for adding to
    }

    @GetMapping("/")
    public List<User> test(){
        return service.all();
    }

    private Group updateGroup(StudentProjection projection){
        Group group = projection.getGroup();
        String id = projection.getUser().getId();
        if(group.getStudentIds() != null){
            List<String> ids = group.getStudentIds();
            ids.add(id);
            group.setStudentIds(ids);
            return  group;
        }
        List<String> ids = new ArrayList<>();
        ids.add(id);
        group.setStudentIds(ids);
        return group;
    }


}
