package com.example.mybatisplussample.ds1.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplussample.entity.UserEntity1;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserServiceMapper1 extends BaseMapper<UserEntity1> {
    @Select({
            "select * from user_info"
    })
    @Results({
            @Result(property = "userId", column = "user_id")
    })
    List<UserEntity1> getAll();
}
