package com.example.springbootwebsocketclient;

import com.example.springbootwebsocketclient.config.MyWebSocketClient;
import org.java_websocket.client.WebSocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2023/10/13 20:03
 */
@RestController
@RequestMapping("/websocket")
public class WebSocketClientController {


    @Resource
    WebSocketClient webSocketClient ;
    @RequestMapping("/index")
    public String sendMessage(String message) {

        webSocketClient.send("测试消息");
        return "消息发送成功";
    }
}


