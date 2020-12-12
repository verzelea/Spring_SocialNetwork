package com.example.demo.controller;

import java.util.Optional;

import com.example.demo.entity.UserEntity;
import com.example.demo.services.userService.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public Iterable<UserEntity> getAllUser(){
        return this.userService.getAlluser();
    }

    @GetMapping("/user/{id}")
    public Optional<UserEntity> getUserById(@PathVariable("id") int id){
        return this.userService.getUserById(id);
    }
}
