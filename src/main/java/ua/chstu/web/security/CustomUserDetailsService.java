package ua.chstu.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.chstu.data.domain.User;
import ua.chstu.data.repositories.UserRepository;
import ua.chstu.data.services.impl.UserService;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService service;

    @Autowired
    private UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("[LOADED]" + s);
        User user = repository.findUserByLogin(s);

        if(user ==null){
            System.out.println("[USER NULL]");
            throw  new UsernameNotFoundException("User " +s);
        }else{
            System.out.println("[LOADED]");
            String role = "USER";
            if (user.getRole() != null) {
                 role = user.getRole();
            }
            return new UserSecurity(user,role);
        }
    }
}
