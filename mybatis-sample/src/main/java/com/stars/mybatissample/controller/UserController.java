package com.stars.mybatissample.controller;

import com.stars.mybatissample.entity.UserEntity;
import com.stars.mybatissample.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author laboratory
 * @Date 2022/10/26 16:56
 */
@RestController
@RequestMapping("/mybatis/user")
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("list")
    public List<UserEntity> getAll() {
        return userService.getAll();
    }

}
