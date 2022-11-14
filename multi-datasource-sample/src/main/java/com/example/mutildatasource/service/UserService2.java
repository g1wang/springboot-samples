package com.example.mutildatasource.service;

import com.example.mutildatasource.ds2.user.mapper.UserServiceMapper2;
import com.example.mutildatasource.entity.UserEntity2;
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
