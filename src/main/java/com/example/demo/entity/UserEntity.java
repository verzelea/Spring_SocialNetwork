package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;
import java.util.Set;

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
    @JoinTable(name = "friend",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "user_id"))
    private Set<UserEntity> users_list;

    public UserEntity(){}

    public int getId_user() {
        return user_id;
    }

    public void setId_user(int user_id) {
        this.user_id = user_id;
    }

    public String getnom() {
        return nom;
    }

    public void setnom(String nom) {
        this.nom = nom;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String getprenom() {
        return prenom;
    }

    public void setprenom(String prenom) {
        this.prenom = prenom;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public Date getbirthday() {
        return birthday;
    }

    public void setbirthday(Date birthday) {
        this.birthday = birthday;
    }
}
