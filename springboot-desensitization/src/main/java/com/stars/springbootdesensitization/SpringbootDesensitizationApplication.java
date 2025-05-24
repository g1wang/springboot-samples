package com.stars.springbootdesensitization;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("com.stars.springbootdesensitization.dbdesen.mapper")

public class SpringbootDesensitizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDesensitizationApplication.class, args);
    }
    @Autowired
    DataSource dataSource;

    @PostConstruct
    public void checkDataSource() {
        System.out.println("当前数据源为：" + dataSource.getClass());
    }
}
