package com.stars.springbootsharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.stars.springbootsharding.mapper")
public class SpringbootShardingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootShardingApplication.class, args);
    }

}
