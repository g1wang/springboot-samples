package com.stars.excelsample.service;

import com.stars.excelsample.entity.Query;
import com.stars.excelsample.entity.UserEntity;
import com.stars.excelsample.mapper.UserMapper;
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
     * @return java.util.List<com.stars.mybatissample.entity.UserEntity>
     * @Author laboratory
     * @Description
     * @Date 18:32 2022/10/26
     * @Param []
     **/
    public List<UserEntity> getAll() {
        return userMapper.getAll();
    }

    public List<UserEntity> export(Query query) {
        return userMapper.export(query);
    }
}
