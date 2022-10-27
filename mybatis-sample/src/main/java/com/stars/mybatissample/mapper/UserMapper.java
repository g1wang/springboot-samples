package com.stars.mybatissample.mapper;

import com.stars.mybatissample.entity.UserEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select({
            "select * from user_info"
    })
    @Results({
            @Result(property = "userId", column = "user_id")
    })
    List<UserEntity> getAll();
}
