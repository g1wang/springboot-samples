package com.example.springbootopenfeign.web;

import com.example.springbootopenfeign.service.feign.CacheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author wanggl
 * @Date 2024/6/24 11:07
 */
@RestController
@RequestMapping
public class CacheController {
    @Resource
    CacheService cacheService;
    @GetMapping("cache")
    public String getCache(String name){
        return cacheService.getCache();
    }
}
