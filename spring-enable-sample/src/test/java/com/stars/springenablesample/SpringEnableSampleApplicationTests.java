package com.stars.springenablesample;

import com.stars.springenablesample.service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringEnableSampleApplicationTests {
    @Autowired
    HelloService helloService;

    @Test
    void contextLoads() {
        System.out.printf(helloService.helloGalaxy());
    }

}
