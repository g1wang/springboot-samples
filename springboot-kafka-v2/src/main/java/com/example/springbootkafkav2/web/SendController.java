package com.example.springbootkafkav2.web;

import com.example.springbootkafkav2.domain.SendReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/7/15 11:13
 */
@RestController
@RequestMapping("kafka-demo")
@Slf4j
public class SendController {

    @Autowired
    private KafkaTemplate<Object,Object> kafkaTemplate ;
    
    @PostMapping("send")
    public void  send(@RequestBody SendReq sendReq){

        for (int i = 0; i < sendReq.getBatchSize(); i++) {
            kafkaTemplate.send("test-cur","msg"+sendReq.getPrefix()+i);
        }
    }
    
    
}
