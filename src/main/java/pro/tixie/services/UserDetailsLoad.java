package pro.tixie.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pro.tixie.model.User;
import pro.tixie.repos.UserRepository;
import pro.tixie.security.UserWithRoles;


@Service
public class UserDetailsLoad implements UserDetailsService {
    private final UserRepository users;

    public UserDetailsLoad(UserRepository users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("No user found for " + username);
        }
        return new UserWithRoles(user);
    }
}