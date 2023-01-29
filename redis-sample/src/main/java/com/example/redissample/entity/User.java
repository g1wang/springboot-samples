package com.example.redissample.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author laboratory
 * @Date 2023/1/29
 */
@Data
public class User implements Serializable {


    public User(String email, String name, String passwd) {
        this.email = email;
        this.name = name;
        this.passwd = passwd;
    }

    private String email;
    private String name;
    private String passwd;
}
