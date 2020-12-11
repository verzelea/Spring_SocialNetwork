package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.services.userService.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public Iterable<UserEntity> getAlluserParam(){
        return this.userService.getAlluser();
    }
}
