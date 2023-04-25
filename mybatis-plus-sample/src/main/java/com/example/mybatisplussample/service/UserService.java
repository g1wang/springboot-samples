package com.example.mybatisplussample.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplussample.mapper.UserMapper;
import com.example.mybatisplussample.entity.UserEntity1;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author laboratory
 * @Date 2022/11/14 10:56
 */
@Service
public class UserService extends ServiceImpl<UserMapper, UserEntity1> {
}
