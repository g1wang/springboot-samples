package com.stars.springenablesample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author wanggl
 * @Date 2025/5/14 9:57
 */
//@Configuration
public class HelloConfiguration {
    @Bean
    public String helloWorld() {
        return "Hello World!!!";
    }

    @Bean
    public String helloGalaxy() {
        return "Hello Galaxy!!!";
    }
}
