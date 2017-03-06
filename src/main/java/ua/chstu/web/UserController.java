package ua.chstu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.chstu.data.domain.User;
import ua.chstu.data.services.impl.UserService;

import java.util.List;

@RestController()
@RequestMapping("user")
public class UserController {


    @Autowired
    private UserService service;

    @PostMapping("/new")
    public String register(@RequestBody User user){
        System.out.println(user.toString());
        service.save(user);
        return "Added successful";
    }

    @GetMapping("/")
    public List<User> test(){
        return service.all();
    }

}
