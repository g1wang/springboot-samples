package com.example.mutildatasource.ds2.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mutildatasource.entity.UserEntity2;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserServiceMapper2 extends BaseMapper<UserEntity2> {
    @Select({
            "select * from user_info"
    })
    @Results({
            @Result(property = "userId", column = "user_id")
    })
    List<UserEntity2> getAll();
}
