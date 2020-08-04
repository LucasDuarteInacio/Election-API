package com.project.Electionapi.service;

import com.project.Electionapi.entity.User;
import com.project.Electionapi.repository.UserRepository;
import com.project.Electionapi.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).get();

        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        return new UserSS(user.getId(),user.getPassword(),user.getEmail(), user.getProfiles());
    }
}
