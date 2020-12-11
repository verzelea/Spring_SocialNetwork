package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "post")
public class PostEntity {
    @Id
    private int post_id;
    private String text;
    private int user_id;
    private boolean private_post;

    public PostEntity(){}

    public int getId_post() {
        return post_id;
    }

    public void setId_post(int post_id) {
        this.post_id = post_id;
    }

    public String gettext() {
        return text;
    }

    public void settext(String text) {
        this.text = text;
    }

    public int getuser_id() {
        return user_id;
    }

    public void setuser_id(int user_id) {
        this.user_id = user_id;
    }

    public boolean getprivate_post() {
        return private_post;
    }

    public void setprivate_post(boolean private_post) {
        this.private_post = private_post;
    }
}
