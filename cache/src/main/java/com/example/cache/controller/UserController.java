package com.example.cache.controller;

import com.example.cache.dto.UserDto;
import com.example.cache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userServiceImpl;

    @GetMapping
    public UserDto getUser(String username){
        return userServiceImpl.getUser(username);
    }
}
