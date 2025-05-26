package com.stars.springbootsharding.web;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.stars.springbootsharding.domain.UserInfo;
import com.stars.springbootsharding.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2025/5/23 14:28
 */
@RestController
@RequestMapping("user-info")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @PostMapping
    public String addUserInfo(@RequestBody UserInfo userInfo) {
        userInfoService.save(userInfo);
        return "success";
    }

    @GetMapping("list")
    public List<UserInfo> getUserInfo() {
        return userInfoService.list(new LambdaQueryWrapper<UserInfo>().orderByDesc(UserInfo::getUserId).last("limit 5"));
    }

    @GetMapping("count")
    public List<Integer> getUserInfoCount() {
        return userInfoService.countUserInfo();
    }
}
