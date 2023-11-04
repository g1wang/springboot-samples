package com.example.mybatisplussample;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@MapperScan(basePackages = "com.example.mybatisplussample..mapper")
@Slf4j
public class MybatisPlusSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusSampleApplication.class, args);
        log.warn("启动：{}",2023);
    }

}
