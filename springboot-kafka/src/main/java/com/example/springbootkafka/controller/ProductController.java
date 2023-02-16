package com.example.springbootkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping
    public void product() {
        String message = "this in my house 2000";
        System.out.println("kafka的消息=" + message);
        kafkaTemplate.send("wwtest", "wwkey", message);
        //kafkaTemplate.send("wwtest",  message);
        System.out.println("发送kafka成功.");
    }
}
