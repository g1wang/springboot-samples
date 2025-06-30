package com.stars.springbootsecurityauth.web;

import com.stars.securityjwtspringbootstater.configration.util.JwtRSAUtils;
import com.stars.springbootsecurityauth.config.AuthConfigration;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author wanggl
 * @Date 2023/11/24 8:57
 */
@RestController
@RequestMapping({"user",})
@Slf4j
public class AuthController {

    @Resource
    JwtRSAUtils jwtRSAUtils;
    @Resource
    AuthConfigration authConfigration;


    @Resource
    RedissonClient redissonClient;

    /**
     * @return
     * @Author wanggl
     * @Description 认证用户、返回用户凭证，包含授权信息
     * @Date 10:25 2025/6/25
     * @Param [userId, password]
     **/
    @PostMapping("login")
    public String login(String userId, String password) {
        redissonClient.getMapCache("ACCESS_TOKEN").put(userId, "token");
        Map<String, String> payload = new HashMap<>();
        payload.put("id", userId);
        payload.put("name", "n123");
        return jwtRSAUtils.generateToken("123", "qwe");
    }

    @PostMapping("refresh")
    public String refresh(@RequestHeader("Authorization") String token) {
        String userId = jwtRSAUtils.getSubject(token);
        redissonClient.getMapCache("ACCESS_TOKEN").put(userId, "token");
        Map<String, String> payload = new HashMap<>();
        payload.put("id", userId);
        payload.put("name", "n123");
        return jwtRSAUtils.generateToken("123", "qwe");
    }

    /**
     * @return
     * @Author wanggl
     * @Description 用户退出登录，清除凭证
     * @Date 10:28 2025/6/25
     * @Param [userId]
     **/
    @PostMapping("logout")
    public String logout(@RequestHeader("Authorization") String token) {
        String userId = jwtRSAUtils.getSubject(token);
        redissonClient.getMapCache("ACCESS_TOKEN").remove(userId);
        return "OK";
    }

    @DeleteMapping("delete")
    public String delUser(@RequestHeader("Authorization") String token) {
        redissonClient.getMapCache("ACCESS_TOKEN").remove(jwtRSAUtils.getSubject(token));
        return "OK";
    }


}
