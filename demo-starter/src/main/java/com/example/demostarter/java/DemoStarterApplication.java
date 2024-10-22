package com.example.demostarter.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/9/14 16:31
 */
@EnableCaching
@SpringBootApplication
public class DemoStarterApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoStarterApplication.class, args);
    }
}
