package com.example.redissample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class RedisSampleApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    void contextLoads() {

    }

    @Test
    void push(){
        stringRedisTemplate.convertAndSend("string-topic","hello world");
    }

}
