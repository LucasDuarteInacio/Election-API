package com.project.Electionapi.controller;

import com.project.Electionapi.entity.User;
import com.project.Electionapi.repository.UserRepository;
import com.project.Electionapi.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService service;

    @GetMapping
    @ApiOperation(value = "returns list of registered users")
    public List<User> list() {
        return userRepository.findAll();
    }

    @PostMapping
    @ApiOperation(value = "Register new user")
    public User addUser(@RequestBody @Valid User user) {
        return service.add(user);
    }


    @PutMapping
    @ApiOperation(value = "Change user by ID")
    public User alterUser(@RequestBody User user) {
        return service.alterUser(user);
    }

    @DeleteMapping(value = "/{idUser}")
    @ApiOperation(value = "Delete user by ID")
    public void deleteUser(@PathVariable("idUser") Integer idUser) {
        service.deleteUser(idUser);
    }


}