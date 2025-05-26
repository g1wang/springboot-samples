package com.stars.springbootsharding.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stars.springbootsharding.domain.UserInfo;
import com.stars.springbootsharding.service.UserInfoService;
import com.stars.springbootsharding.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author wanggl
* @description 针对表【user_info】的数据库操作Service实现
* @createDate 2025-05-23 14:24:38
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

    /**
     * @return
     */
    @Override
    public List<Integer> countUserInfo() {
        return getBaseMapper().countUserInfo();
    }
}




