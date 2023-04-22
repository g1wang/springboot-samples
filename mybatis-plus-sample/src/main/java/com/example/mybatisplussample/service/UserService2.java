package com.example.mybatisplussample.service;

import com.example.mybatisplussample.ds2.user.mapper.UserServiceMapper2;
import com.example.mybatisplussample.entity.UserEntity2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author laboratory
 * @Date 2022/11/14 10:56
 */
@Service
public class UserService2 {

    @Resource
    UserServiceMapper2 userServiceMapper2;

    public List<UserEntity2> getAll() {
        return userServiceMapper2.getAll();

    }
}
