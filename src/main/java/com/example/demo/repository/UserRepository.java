package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path="users")
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query(value = "select * from User", nativeQuery = true)
    Iterable<UserEntity> findAlluser();

    @Query(value = "select * from User where User.username=?1", nativeQuery=true)
    UserEntity findByUsername(String username);
}
