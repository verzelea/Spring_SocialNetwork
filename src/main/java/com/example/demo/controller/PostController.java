package com.example.demo.controller;

import java.util.Optional;

import com.example.demo.entity.PostEntity;
import com.example.demo.services.postService.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/")
    public Iterable<PostEntity> getAllPost(){
        return this.postService.getAllpost();
    }

    @GetMapping("/{id}")
    public Optional<PostEntity> getUserById(@PathVariable("id") int id){
        return this.postService.getPostById(id);
    }
}
