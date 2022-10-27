package com.stars.mybatissample.service;

import com.stars.mybatissample.entity.UserEntity;
import com.stars.mybatissample.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author laboratory
 * @Date 2022/10/26 17:04
 */
@Service
public class UserService {
    @Resource
    UserMapper userMapper;

    /**
    * @Author laboratory
    * @Description
    * @Date 18:32 2022/10/26
    * @Param []
    * @return java.util.List<com.stars.mybatissample.entity.UserEntity>
    **/
    public List<UserEntity> getAll(){
        return userMapper.getAll();
    }
}
