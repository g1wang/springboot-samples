package com.example.mybatisplussample.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplussample.entity.UserEntity1;
import com.example.mybatisplussample.entity.UserEntity2;
import com.example.mybatisplussample.service.UserInfoService;
import com.example.mybatisplussample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author laboratory
 * @Date 2022/11/14 10:54
 */
@RestController
@RequestMapping("mutilDataSource")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserInfoService userInfoService;

    @GetMapping("ds1")
    public Page<UserEntity1> getByIdDs1() {
        Page<UserEntity1> page = new Page<>(0,10);
        return userService.page(page);
    }

    @GetMapping("ds2")
    public Page<UserEntity2> getByIdDs2() {
        Page<UserEntity2> page = new Page<>(1, 30);
        return userInfoService.page(page);
    }
}
