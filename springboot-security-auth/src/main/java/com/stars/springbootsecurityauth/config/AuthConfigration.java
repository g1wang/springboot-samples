package com.stars.springbootsecurityauth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description:
 * @Author wanggl
 * @Date 2025/6/19 18:32
 */
@ConfigurationProperties(prefix = "auth")
@Component
@Data
public class AuthConfigration {

    private String enabled;
    private String cacheKey;
    private String header;
    private List<String> whiteList;
}

