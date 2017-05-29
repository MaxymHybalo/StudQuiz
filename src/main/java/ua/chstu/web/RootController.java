package ua.chstu.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.chstu.data.domain.Category;
import ua.chstu.data.domain.QCase;
import ua.chstu.data.domain.Subject;
import ua.chstu.data.domain.User;
import ua.chstu.data.repositories.CategoriesRepository;
import ua.chstu.data.services.impl.UserService;
import ua.chstu.web.security.UserSecurity;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller()
public class RootController {

    @Autowired
    private UserService service;

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

    @GetMapping("/profile")
    @ResponseBody
    public ResponseEntity contextUser(){
        //change this logic to SessionHolder method
        UserSecurity  authenticated;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserSecurity){
            authenticated = (UserSecurity) principal;
            User user = service.byLogin(authenticated.getUsername());
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(principal.getClass().getName());
    }
}
