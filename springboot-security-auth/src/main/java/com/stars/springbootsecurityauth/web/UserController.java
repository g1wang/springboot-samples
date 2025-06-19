package com.stars.springbootsecurityauth.web;

import com.stars.springbootsecurityjwt.util.JwtUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author wanggl
 * @Date 2023/11/24 8:57
 */
@RestController
@RequestMapping({"user","test"})
@Slf4j
public class UserController {

    @Resource
    JwtUtils jwtUtils;

    @GetMapping("login")
    public String login() {
        Map<String, String> payload = new HashMap<>();
        payload.put("id", String.valueOf(2021));
        payload.put("name", "n123");
        return jwtUtils.generateToken("123", "qwe", KeyManager.getPrivateKey());
    }

    @GetMapping("verify")
    public String verify(String name) {
        //Map<String, Claim> map = jwtUtils.(token);
        //return map.get("name").asString();
        log.info("name:{}",name);
        return name;
    }


}
