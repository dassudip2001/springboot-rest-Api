package com.example.java.full.stack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java.full.stack.model.User;
import com.example.java.full.stack.repository.UserRepository;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }
    // @GetMapping(value="/users")
    // public SomeData getMethodName(@RequestParam String param) {
    //     return new SomeData();
    // }
    // @GetMapping
    // public List<User> getAllUser() {
    //     return userService.getAllUser();
    // }
    
}
