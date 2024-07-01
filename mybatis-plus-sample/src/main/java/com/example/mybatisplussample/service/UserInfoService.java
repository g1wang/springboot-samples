package com.example.mybatisplussample.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplussample.entity.UserEntity2;
import com.example.mybatisplussample.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author laboratory
 * @Date 2022/11/14 10:56
 */
@Service
//@DS("tdengine")
public class UserInfoService extends ServiceImpl<UserInfoMapper, UserEntity2>  {

}
