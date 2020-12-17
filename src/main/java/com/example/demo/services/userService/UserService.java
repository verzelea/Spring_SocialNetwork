package com.example.demo.services.userService;

import java.util.Optional;

import com.example.demo.entity.UserEntity;

public interface UserService {

    public Iterable<UserEntity>getAlluser();

    Optional<UserEntity> getUserById(int id);

    public UserEntity save(UserEntity user);
}
