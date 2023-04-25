package com.example.mybatisplussample.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplussample.mapper.UserInfoMapper;
import com.example.mybatisplussample.entity.UserEntity2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author laboratory
 * @Date 2022/11/14 10:56
 */
@Service
public class UserInfoService extends ServiceImpl<UserInfoMapper, UserEntity2>  {

}
