package com.example.redissample.service;

import com.example.redissample.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;

/**
 * @Description:
 * @Author laboratory
 * @Date 2023/1/29
 */
@Service
public class UserService {

    @Cacheable(value = "user-key")
    public User getUser(String email) throws ValidationException {
        User user ;
        System.out.println("无缓存的时候调用");
        if ("aa@123.com".equals(email)){
            user = new User();
            user.setEmail("aa@123.com");
            user.setName("aaa");
            user.setPasswd("aa123");
        }else throw new ValidationException("user not exist");
        return user;
    }
}
