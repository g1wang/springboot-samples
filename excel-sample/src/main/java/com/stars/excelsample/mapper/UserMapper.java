package com.stars.excelsample.mapper;

import com.stars.excelsample.entity.Query;
import com.stars.excelsample.entity.UserEntity;
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

    @Select({
            "select * from user_info limit #{startRow} ,#{lines} "
    })
    @Results({
            @Result(property = "userId", column = "user_id")
    })
    List<UserEntity> export(Query query);
}
