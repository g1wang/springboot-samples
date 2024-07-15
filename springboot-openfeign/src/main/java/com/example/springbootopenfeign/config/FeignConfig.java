package com.example.springbootopenfeign.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author wanggl
 * @Date 2024/7/8 16:50
 */
@Configuration
public class FeignConfig implements RequestInterceptor {
    /**
     * @param requestTemplate
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        //requestTemplate.header();

    }
}
