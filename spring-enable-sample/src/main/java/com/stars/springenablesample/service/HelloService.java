package com.stars.springenablesample.service;

import com.stars.springenablesample.config.EnableHello;
import com.stars.springenablesample.config.HelloConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2025/5/14 10:04
 */
@Service
@EnableHello
public class HelloService {

    @Autowired
    private String  helloGalaxy;

    public String helloGalaxy() {
        return helloGalaxy;
    }
}
