package com.stars.sb231204jwt;

import com.auth0.jwt.interfaces.Claim;
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
@RequestMapping("user")
public class UserController {

    @GetMapping("login")
    public String login() {
        Map<String, String> payload = new HashMap<>();
        payload.put("id", String.valueOf(2021));
        payload.put("name", "n123");
        String token = JwtUtils.getToken(payload);
        return token;
    }
    @GetMapping("verify")
    public String verify(String token) {
        Map<String, Claim> map = JwtUtils.getTokenInfo(token);
        return map.get("name").asString();
    }


}
