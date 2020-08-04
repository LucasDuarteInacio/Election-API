package com.project.Electionapi.service;

import com.project.Electionapi.entity.User;
import com.project.Electionapi.exception.ApiException;
import com.project.Electionapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public User add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User alterUser(User user) {
        return userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public User findById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ApiException("Usuario com id: " + id + " não encontrado!",
                "Tipo: " + User.class.getName(), HttpStatus.NOT_FOUND.value()));
    }

    public void deleteUser(Integer idUser) {
        User user = findById(idUser);
        delete(user);

    }

}

