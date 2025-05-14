package com.stars.springenablesample;

import com.stars.springenablesample.config.EnableHello;
import com.stars.springenablesample.config.HelloConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringEnableSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringEnableSampleApplication.class, args);

    }

}
