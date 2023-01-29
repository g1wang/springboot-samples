package com.example.redissample.controller;

import com.example.redissample.entity.User;
import com.example.redissample.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;

/**
 * @Description:
 * @Author laboratory
 * @Date 2023/1/29
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    /**
     * @return com.example.redissample.entity.User
     * @Author laboratory
     * @Description http://127.0.0.1:8080/user?email=aa@123.com
     * @Date 2023/1/29
     * @Param [user]
     **/
    @GetMapping
    public User getUser(String email) throws ValidationException {
        return userService.getUser(email);
    }

}
