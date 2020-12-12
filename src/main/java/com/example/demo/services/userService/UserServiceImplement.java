package com.example.demo.services.userService;

import java.util.Optional;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class UserServiceImplement implements UserService{
    @Autowired
    UserRepository userRepository;

    @Transactional
    @Override
    public Iterable<UserEntity> getAlluser() {
        return this.userRepository.findAlluser();
    }

    @Transactional
    @Override
    public Optional<UserEntity> getUserById(int id){
        return this.userRepository.findById(id);
    }
}
