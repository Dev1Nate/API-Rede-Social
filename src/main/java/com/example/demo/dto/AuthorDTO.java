package com.example.demo.dto;

import com.example.demo.entities.User;

import java.io.Serializable;

public class AuthorDTO implements Serializable {

    private String id;
    private String name;

    public AuthorDTO() {
    }

    public AuthorDTO(User user){
        id = user.getId();
        name = user.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
