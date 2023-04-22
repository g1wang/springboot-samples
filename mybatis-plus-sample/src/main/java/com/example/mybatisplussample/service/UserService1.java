package com.example.mybatisplussample.service;

import com.example.mybatisplussample.ds1.user.mapper.UserServiceMapper1;
import com.example.mybatisplussample.entity.UserEntity1;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author laboratory
 * @Date 2022/11/14 10:56
 */
@Service
public class UserService1 {

    @Resource
    UserServiceMapper1 userServiceMapper1;

    public List<UserEntity1> getAll( ) {
        return userServiceMapper1.getAll();

    }
}
