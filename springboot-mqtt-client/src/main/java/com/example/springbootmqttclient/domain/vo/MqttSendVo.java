package com.example.springbootmqttclient.domain.vo;

import lombok.Data;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/4/12 10:48
 */
@Data
public class MqttSendVo {
    private String topic;
    private String msg;
    private Integer qos;
    private Boolean retained;
}
