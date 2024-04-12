package com.example.springbootmqttclient.controller;

import com.example.springbootmqttclient.bean.MqttSendClient;
import com.example.springbootmqttclient.domain.vo.MqttSendVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/4/12 8:50
 */
@RestController
@RequestMapping("/mqtt")
public class MqttSendController {
    @Autowired
    MqttSendClient mqttSendClient;

    @PostMapping("send")
    public String send(@RequestBody MqttSendVo mqttSendVo){
        mqttSendClient.publish(false, mqttSendVo.getTopic(), mqttSendVo.getMsg());
        return  "OK";

    }
}
