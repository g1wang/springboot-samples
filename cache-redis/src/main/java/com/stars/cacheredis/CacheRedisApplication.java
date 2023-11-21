package com.stars.cacheredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class CacheRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(CacheRedisApplication.class, args);
    }

}
