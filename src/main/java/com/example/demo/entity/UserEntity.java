package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

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
