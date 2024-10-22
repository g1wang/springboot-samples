package com.example.mybatisplussample.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplussample.entity.SexEnum;
import com.example.mybatisplussample.entity.UserEntity1;
import com.example.mybatisplussample.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Description:
 * @Author laboratory
 * @Date 2022/11/14 10:56
 */
@Service
public class UserService extends ServiceImpl<UserMapper, UserEntity1> {
    @Resource
    UserAddService userAddService;
    public UserEntity1 save1and2(){

        UserEntity1 userEntity = new UserEntity1();
        try {
            userEntity.setAge(33);
            userEntity.setScore(BigDecimal.valueOf(60));
            userEntity.setSexEnum(SexEnum.FEMALE);
            userAddService.save1(userEntity);
            UserEntity1 userEntity2 = new UserEntity1();
            userEntity2.setAge(44);
            userEntity2.setScore(BigDecimal.valueOf(70));
            userEntity2.setSexEnum(SexEnum.MALE);

            userAddService.save2(userEntity2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userEntity;
    }

}
