package com.example.demo.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.entity.UserEntity;
import com.example.demo.services.userService.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@BasePathAwareController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/users")
    public ResponseEntity redirectSignUp() throws URISyntaxException {
        HttpHeaders headers = new HttpHeaders();
        if(System.getenv("PROD_URL") != null) {
            headers.setLocation(new URI(System.getenv("PROD_URL") + "/users/sign-up"));
        
        } else headers.setLocation(new URI("http://localhost:8080/users/sign-up"));

        return new ResponseEntity<>(headers, HttpStatus.TEMPORARY_REDIRECT);
    }

    @PostMapping("/users/sign-up")
    public ResponseEntity signUp(@RequestBody UserEntity user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.save(user);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}