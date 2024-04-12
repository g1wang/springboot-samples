package com.example.springbootmqttclient.controller;

import com.example.springbootmqttclient.bean.MyMqttClient;
import com.example.springbootmqttclient.domain.vo.MqttSendVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/4/12 8:50
 */
@RestController
@RequestMapping("/mqtt")
public class MqttSendController {

    @Resource
    MyMqttClient myMqttClient;

    @PostMapping("send")
    public String send(@RequestBody MqttSendVo mqttSendVo){
        myMqttClient.publish(mqttSendVo.getRetained(),mqttSendVo.getTopic(), mqttSendVo.getMsg(),mqttSendVo.getQos());
        return  "OK";

    }
}
