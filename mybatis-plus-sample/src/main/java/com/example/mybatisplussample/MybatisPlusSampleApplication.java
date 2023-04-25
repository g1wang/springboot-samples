package com.example.mybatisplussample;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@MapperScan(basePackages = "com.example.mybatisplussample..mapper")
public class MybatisPlusSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusSampleApplication.class, args);
    }

}
