package com.example.springbootskywalking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
* @Author wanggl
* @Description
 * -javaagent:D:\Programs\apache-skywalking-java-agent-9.2.0\skywalking-agent\skywalking-agent.jar
 * -Dskywalking.agent.service_name=sw-demo
 * -Dskywalking.collector.backend_service=127.0.0.1:11800
* @Date 10:16 2024/6/25
* @Param
* @return
**/
@SpringBootApplication
public class SpringbootSkywalkingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSkywalkingApplication.class, args);
    }

}
