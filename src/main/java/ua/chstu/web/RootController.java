package ua.chstu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller()

public class RootController {

    @PostMapping("/login")
    @ResponseBody
    public String login(){
        return "OK";
    }

    @PostMapping("/logout")
    @ResponseBody
    public String logout(){
        return "OK";
    }

}
