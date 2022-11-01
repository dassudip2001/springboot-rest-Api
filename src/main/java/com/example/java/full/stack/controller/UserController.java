package com.example.java.full.stack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.java.full.stack.exception.UserNotFoundException;
import com.example.java.full.stack.model.User;
import com.example.java.full.stack.repository.UserRepository;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    // post Api
    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }
    // @GetMapping(value="/users")
    // public SomeData getMethodName(@RequestParam String param) {
    //     return new SomeData();
    // }
    
    // get api
    @GetMapping("/users")
     List<User> getAllUsers(){
        return userRepository.findAll();
     }

    //  get by id
    @GetMapping("/user/{id}")
    // Optional<User> getUserById(@PathVariable Long id){
    //     return userRepository.findById(id);
    User getUserById(@PathVariable Long id){
        return userRepository.findById(id)
        .orElseThrow(()->new UserNotFoundException(id));
    }

    // }

    // update
    @PutMapping("user/{id}")
    Optional<Object> updatUser(@RequestBody User newUser,@PathVariable Long id){
        return userRepository.findById(id)
        .map(user->{
            user.setUsername(newUser.getUsername());
            user.setEmail(newUser.getEmail());
            user.setName(newUser.getName());
            user.setAddress(newUser.getAddress());
            user.setAge(newUser.getAge());
            user.setDepartment(newUser.getDepartment());
            user.setSalary(newUser.getSalary());
            return userRepository.save(user);
        });
    }

    // delete
    @DeleteMapping("user/{id}")
    String deleteuser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
           throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "successfully delete";
    }
    
}
