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
    private String email;
    private String name;
    private String passwd;
}
