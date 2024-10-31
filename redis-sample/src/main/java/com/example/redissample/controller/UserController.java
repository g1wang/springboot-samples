package com.example.redissample.controller;

import com.example.redissample.entity.User;
import com.example.redissample.service.UserService;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.xml.bind.ValidationException;
import java.util.UUID;

/**
 * @Description:
 * @Author laboratory
 * @Date 2023/1/29
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @Autowired
    RedissonClient redissonClient;

    /**
     * @return com.example.redissample.entity.User
     * @Author laboratory
     * @Description http://127.0.0.1:8080/user?email=aa@123.com
     * @Date 2023/1/29
     * @Param [user]
     **/
    @GetMapping
    public User getUser(String email) throws ValidationException {
        RTopic toSendEMailAddress = redissonClient.getTopic("string-topic");
        toSendEMailAddress.publish(email);
        return userService.getUser(email);
    }

    @GetMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
}
