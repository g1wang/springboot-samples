package com.stars.springbootsecurityauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages  = {"com.stars.*"})
public class SpringbootSecurityAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSecurityAuthApplication.class, args);
    }

}
