package com.example.springbootwebsocketclient;

import org.java_websocket.client.WebSocketClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2023/10/13 20:03
 */
@RestController
@RequestMapping("/websocket")
public class WebSocketClient2Controller {


    @Resource
    WebSocketClient webSocketClient ;
    @RequestMapping("/index2")
    public String sendMessage(String message) {

        webSocketClient.send("测试消息");
        return "消息发送成功";
    }
}


