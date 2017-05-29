package ua.chstu.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ua.chstu.data.domain.User;
import ua.chstu.data.services.impl.UserService;

@Component
public class SessionHolder {

    @Autowired
    private UserService service;

    public User authenticatedUser(){
        UserSecurity  authenticated;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserSecurity){
            authenticated = (UserSecurity) principal;
            User user = service.byLogin(authenticated.getUsername());
            return user;
        }
        return null;
    }
}
