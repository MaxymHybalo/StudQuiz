package ua.chstu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.chstu.data.domain.User;
import ua.chstu.data.services.impl.UserService;

import java.util.List;

@RestController()
@RequestMapping("user")
public class UserController {

    private final String SIGN_UP_SUCCESS_MSG = "Ви успішно зареєструвалися!";

    @Autowired
    private UserService service;

    @PostMapping("/new")
    public String register(@RequestBody User user){
        System.out.println(user.toString());
        service.save(user);
        return SIGN_UP_SUCCESS_MSG;
    }

    @GetMapping("/")
    public List<User> test(){
        return service.all();
    }

}
