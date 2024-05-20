package com.example.logabckdesensitization;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class LogabckDesensitizationApplicationTests {


    @Test
    void contextLoads() {

        log.info("your email:{}, your phone:{}", "123456789@qq.com","15310763497");
        log.info("your email={}, your cellphone={}", "123456789@qq.com","15310763497");
        log.info("your name={}, your password={}", "我是谁","123456");
        log.info("your username={}, your cellphone={}", "123456789@qq.com","15310763497");
        log.info("your username={}, your cellphone={}", "15310763497","15310763497");
        log.info("your username={}, your cellphone={}", "350212188801011345","15310763497");
        log.info("your username={}, your cellphone={}", "12345678901","15310763497");
    }

}
