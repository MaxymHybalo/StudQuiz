package ua.chstu.web.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.warn("Passed " + username);
        User user = service.authenticatedByLogin(username);
        if(user == null){
            log.warn("Caught null of user");
            throw  new UsernameNotFoundException("User " +username);
        }else{
            log.info("Success passed " + username);
            String role = "USER";
            if (user.getRole() != null) {
                 role = user.getRole();
            }
            return new UserSecurity(user,role);
        }
    }
}
