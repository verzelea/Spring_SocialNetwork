package com.example.demo.repository;

import com.example.demo.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path="posts")
public interface PostRepository extends JpaRepository<PostEntity, Integer> {

    @Query(value = "select * from Post", nativeQuery = true)
    Iterable<PostEntity> findAllpost();
}
