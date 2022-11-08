package com.stars.excelsample;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.stars.excelsample.mapper")
public class ExcelSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExcelSampleApplication.class, args);
    }

}
