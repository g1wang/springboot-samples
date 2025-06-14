package com.stars.springbootsecurityjwt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description:
 * @Author wanggl
 * @Date 2025/6/11 10:18
 */
@Data
@ConfigurationProperties(prefix = "jwt")
@Component
public class JwtProperties {
    /**
     * accessToken 有效时间
     */
    private Long expiration;
    /**
     * 前端向后端传递JWT时使用HTTP的header名称，前后端要统一
     */
    private String header;
    private String privateKeyPath;
    private String publicKeyPath;
    private String issuer;
    private String jwtCacheKey;
    private List<String> whiteList;
}



