package ua.chstu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.chstu.data.domain.study.Group;
import ua.chstu.data.services.impl.GroupService;
import ua.chstu.web.security.SessionHolder;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private SessionHolder holder;

    @Autowired
    private GroupService service;

    @PostMapping
    public List<Group> newGroup(@RequestBody Group group){
        System.out.println(group);
        group.setCreatorId(holder.authenticatedUser().getId());
        service.save(group);
        return service.all();
    }

}