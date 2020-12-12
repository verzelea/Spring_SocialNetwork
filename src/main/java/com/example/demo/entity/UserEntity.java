package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "user")
public class UserEntity {
    @Id
    private int user_id;
    private String nom;
    private String prenom;
    private String password;
    private Date birthday;
    private String description;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(name="friend",
    joinColumns=@JoinColumn(name="person_id"),
    inverseJoinColumns=@JoinColumn(name="friend_id")
    )
    private List<UserEntity> friends;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(name="friend",
    joinColumns=@JoinColumn(name="friend_id"),
    inverseJoinColumns=@JoinColumn(name="person_id")
    )
    private List<UserEntity> friendOf;

    public UserEntity(){}

}
