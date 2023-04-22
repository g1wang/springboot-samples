package com.example.mybatisplussample.controller;

import com.example.mybatisplussample.entity.UserEntity1;
import com.example.mybatisplussample.entity.UserEntity2;
import com.example.mybatisplussample.service.UserService1;
import com.example.mybatisplussample.service.UserService2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author laboratory
 * @Date 2022/11/14 10:54
 */
@RestController
@RequestMapping("mutilDataSource")
public class UserController {

    @Resource
    UserService1 userService1;

    @Resource
    UserService2 userService2;

    @GetMapping("ds1")
    public List<UserEntity1> getByIdDs1() {
        return userService1.getAll();
    }

    @GetMapping("ds2")
    public List<UserEntity2> getByIdDs2() {
        return userService2.getAll();
    }
}
