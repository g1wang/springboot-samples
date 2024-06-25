package com.example.springbootopenfeign.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/6/24 11:05
 */
@FeignClient(name = "feignTestService", url = "http://localhost:8624")
public interface CacheService {

    @GetMapping(value = "/getData/fromCache")
    String getCache();
}
