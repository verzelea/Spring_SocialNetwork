package com.example.demo.controller;

import java.util.Optional;

import com.example.demo.entity.PostEntity;
import com.example.demo.services.postService.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/post")
    public Iterable<PostEntity> getAllPost(){
        return this.postService.getAllpost();
    }

    @GetMapping("/post/{id}")
    public Optional<PostEntity> getUserById(@PathVariable("id") int id){
        return this.postService.getPostById(id);
    }
}
