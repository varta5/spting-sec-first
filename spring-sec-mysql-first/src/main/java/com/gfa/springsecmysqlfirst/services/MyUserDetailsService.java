package com.gfa.springsecmysqlfirst.services;

import com.gfa.springsecmysqlfirst.models.MyUserDetails;
import com.gfa.springsecmysqlfirst.models.User;
import com.gfa.springsecmysqlfirst.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(username);
        User theUser = user.orElse(null);
        if (theUser == null) {
            throw new UsernameNotFoundException("Not found: " + username);
        }
        return new MyUserDetails(theUser);
    }
}
