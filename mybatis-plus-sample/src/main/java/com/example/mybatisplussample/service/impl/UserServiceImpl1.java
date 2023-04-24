package com.example.mybatisplussample.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplussample.ds1.user.mapper.UserMapper1;
import com.example.mybatisplussample.entity.UserEntity1;
import com.example.mybatisplussample.service.UserService1;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author laboratory
 * @Date 2022/11/14 10:56
 */
@Service
public class UserServiceImpl1 extends ServiceImpl<UserMapper1,UserEntity1> implements UserService1 {

    public List<UserEntity1> getAll( ) {
        return getBaseMapper().selectList(null);

    }
}
