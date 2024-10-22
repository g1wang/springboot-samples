package com.example.mybatisplussample.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplussample.entity.UserEntity1;
import com.example.mybatisplussample.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/8/12 11:28
 */
@Service
public class UserAddService extends ServiceImpl<UserMapper, UserEntity1> {
    @Transactional
    public void save1(UserEntity1 userEntity ){
        save(userEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void save2(UserEntity1 userEntity ) throws Exception {
        try {
            save(userEntity);
            throw  new Exception("excep");
        }catch (Exception e){
            throw e;
        }

    }
}
