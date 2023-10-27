package com.example.cache.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private String username;
    private String email;
    private List<String> addressList;
    private Integer age;
}
