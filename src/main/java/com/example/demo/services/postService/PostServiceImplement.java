package com.example.demo.services.postService;

import com.example.demo.entity.PostEntity;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class PostServiceImplement implements PostService{
    @Autowired
    PostRepository postRepository;

    @Transactional
    @Override
    public Iterable<PostEntity> getAllpost() {
        return this.postRepository.findAllpost();
    }
}
