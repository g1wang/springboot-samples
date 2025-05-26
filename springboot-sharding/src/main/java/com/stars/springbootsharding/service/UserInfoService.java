package com.stars.springbootsharding.service;

import com.stars.springbootsharding.domain.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author wanggl
* @description 针对表【user_info】的数据库操作Service
* @createDate 2025-05-23 14:24:38
*/
public interface UserInfoService extends IService<UserInfo> {

    List<Integer> countUserInfo();
}
