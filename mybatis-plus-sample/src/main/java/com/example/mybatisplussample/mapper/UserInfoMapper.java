package com.example.mybatisplussample.mapper;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplussample.entity.UserEntity2;
@DS("tdengine")
public interface UserInfoMapper extends BaseMapper<UserEntity2> {

}
