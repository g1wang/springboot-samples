package com.example.mybatisplussample.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplussample.entity.SexEnum;
import com.example.mybatisplussample.entity.UserEntity1;
import com.example.mybatisplussample.entity.UserEntity2;
import com.example.mybatisplussample.service.UserInfoService;
import com.example.mybatisplussample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author laboratory
 * @Date 2022/11/14 10:54
 */
@RestController
@RequestMapping("mutilDataSource")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserInfoService userInfoService;

    @PostMapping("ds1")
    public UserEntity1 saveds1(){
        UserEntity1 userEntity = new UserEntity1();
        userEntity.setAge(33);
        userEntity.setScore(BigDecimal.valueOf(60));
        userEntity.setSexEnum(SexEnum.FEMALE);
        userService.save(userEntity);
        return userEntity;
    }

    @PostMapping("ds1a2")
    public void   save1and2(){
        userService.save1and2();
    }

    @PutMapping("ds1")
    public UserEntity1 updateds1(@PathParam("id") Integer id){
        UserEntity1 userEntity = userService.getById(id);
        userEntity.setAge(32);
        userEntity.setScore(BigDecimal.valueOf(60));
        userEntity.setSexEnum(SexEnum.FEMALE);
        userService.updateById(userEntity);
        return userEntity;
    }

    @GetMapping("ds1")
    public Page<UserEntity1> getByIdDs1() {
        Page<UserEntity1> page = new Page<>(0, 10);
        QueryWrapper<UserEntity1> queryWrapper = new QueryWrapper<>();
        //queryWrapper.like("sex", 1).and(wq -> wq.ge("age", 30).or().eq("score", 4));
        return userService.page(page, queryWrapper);
    }

    @DeleteMapping("ds1")
    public boolean deleteByIdDs1( Integer id) {
        return userService.removeById(id);
    }

    @GetMapping("ds2")
    public Page<UserEntity2> getByIdDs2() {
        Page<UserEntity2> page = new Page<>(1, 30);
        QueryWrapper<UserEntity2> queryWrapper = new QueryWrapper<>();
        //queryWrapper.like("sex",1).and(wq-> wq.ge("age",30).or().eq("score",4));
        return userInfoService.page(page, queryWrapper);
    }

    @PostMapping("userInfo")
    public void save() {
        List<UserEntity2> list = new ArrayList<>();
        System.out.println(new Date());
        for (int i = 1; i <= 3; i++) {
            UserEntity2 userEntity2 = new UserEntity2();
            userEntity2.setTs(new Timestamp(System.currentTimeMillis()));
            userEntity2.setUserId(2);
            userEntity2.setAge("2");
            userEntity2.setScore("2");
            userEntity2.setSex(1);
            list.add(userEntity2);
            if (list.size() > 0 && i % 10000 == 0) {
                System.out.println("写入1万数据开始：" + new Date());
                userInfoService.saveBatch(list);
                list.clear();
                System.out.println("写入1万数据完成：" + new Date());
            }
            try {
                Thread.sleep(Math.round(1));
            } catch (InterruptedException e) {

            }
        }

    }
}
