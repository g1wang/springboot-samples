package com.example.logabckdesensitization.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/5/9 16:36
 */
@RestController
@RequestMapping
@Slf4j
public class LogbackController {

    @GetMapping("log")
    public String log(){
        log.info("设置tengine客户端http请求异常，调用后端节点请求状态异常等告警,设置tengine客户端http请求异常，调用后端节点请求状态异常等告警,设置tengine客户端http请求异常，调用后端节点请求状态异常等告警,设置tengine客户端http请求异常，调用后端节点请求状态异常等告警,your email:{}, your phone:{}", "123456789@qq.com","15310763497");
        log.info("your email={},设置tengine客户端http请求异常，调用后端节点请求状态异常等告警,设置tengine客户端http请求异常，调用后端节点请求状态异常等告警,设置tengine客户端http请求异常，调用后端节点请求状态异常等告警,设置tengine客户端http请求异常，调用后端节点请求状态异常等告警, your cellphone={}", "123456789@qq.com","15310763497");
        log.info("your name={}, your password={}", "我是谁","123456");
        log.info("your username={}, 设置tengine客户端http请求异常，调用后端节点请求状态异常等告警,设置tengine客户端http请求异常，调用后端节点请求状态异常等告警,设置tengine客户端http请求异常，调用后端节点请求状态异常等告警,设置tengine客户端http请求异常，调用后端节点请求状态异常等告警,your cellphone={}", "123456789@qq.com","15310763497");
        log.info("your username={}, your cellphone={}", "15310763497","15310763497");
        log.info("your username={}, your cellphone={}", "350212188801011345","15310763497");
        log.info("your username={}, 设置tengine客户端http请求异常，调用后端节点请求状态异常等告警,设置tengine客户端http请求异常，调用后端节点请求状态异常等告警,设置tengine客户端http请求异常，调用后端节点请求状态异常等告警,设置tengine客户端http请求异常，调用后端节点请求状态异常等告警,your cellphone={}", "12345678901","15310763497");
        return "OK";
    }

}
