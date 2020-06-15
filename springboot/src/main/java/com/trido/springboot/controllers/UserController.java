package com.trido.springboot.controllers;

import com.trido.springboot.exceptions.UserNotFoundException;
import com.trido.springboot.models.User;
import com.trido.springboot.services.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService services;

    @GetMapping(path = "/users")
    public List<User> getAllUsers(){
        return services.getUsers();
    }

    @GetMapping(path = "/users/{id}")
    public User getUserById(@PathVariable int id){
        User user = services.getUserById(id);
        if(user == null) throw new UserNotFoundException("The user with id " + id + " not found");
        return user;
    }

    @PostMapping(path = "/users")
    public void addUser(@RequestBody User user){
        services.addUser(user);
    }

    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable int id){
        if(services.deleteUser(id) == null)
            throw new UserNotFoundException("The user with id " + id + " not found");
    }

    @PutMapping(path = "/users/{id}")
    public void updateUser(@PathVariable int id, @RequestBody User user){
        services.updateUser(id, user);
    }
}
