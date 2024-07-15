package com.example.springbootkafkav2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
public class SpringbootKafkaV2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootKafkaV2Application.class, args);
    }

}
