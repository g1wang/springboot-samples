package com.example.springbootskywalking.web;

import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.Tag;
import org.apache.skywalking.apm.toolkit.trace.Tags;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author wanggl
 * @Date 2024/6/24 17:28
 */
@RestController
@RequestMapping
@Slf4j
public class DemoController {
    @Trace
    @Tags({
            @Tag(key = "arg[0]", value = "arg[0]"),
            @Tag(key = "result", value = "returnedObj"),
            @Tag(key = "result.uname", value = "returnedObj.uname")
    })
    @GetMapping("demo")
    public String get(String uname) {
        log.info("demo uname:{}", uname);
        return uname == null ? "OK" : uname;
    }
}
