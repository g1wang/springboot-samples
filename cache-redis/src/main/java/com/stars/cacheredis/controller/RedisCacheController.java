package com.stars.cacheredis.controller;

import com.stars.cacheredis.service.RedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2023/11/21 15:55
 */
@RestController
public class RedisCacheController {
    @Autowired
    private RedisCacheService redisCacheService;


    @GetMapping("/getData/fromCache")
    public Map<String,String> getData(String key){
        return redisCacheService.getData(key);
    }

    @GetMapping("/getData/invalid")
    public Map<String,String> invalid(){
        return redisCacheService.invalid();
    }

    @GetMapping("/getData/doubleWrite")
    public Map<String,String> doubleWrite(){
        return redisCacheService.doubleWrite();
    }
}
