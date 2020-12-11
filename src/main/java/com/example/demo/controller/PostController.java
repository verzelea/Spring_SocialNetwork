package com.example.demo.controller;

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
    public Iterable<PostEntity> getAllpostParam(){
        return this.postService.getAllpost();
    }
}
