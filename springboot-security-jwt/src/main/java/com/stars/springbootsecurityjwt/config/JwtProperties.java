package com.stars.springbootsecurityjwt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

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
     * 是否开启JWT，即注入相关的类对象
     */
    private Boolean enabled;
    /**
     * accessToken 有效时间
     */
    private Long expiration;
    /**
     * 前端向后端传递JWT时使用HTTP的header名称，前后端要统一
     */
    private String header;
    /**
     * 用户登录-用户名参数名称
     */
    private String userParamName = "userId";
    /**
     * 用户登录-密码参数名称
     */
    private String pwdParamName = "password";
    /**
     * 是否使用默认的JWTAuthController
     */
    private Boolean useDefaultController = false;

    private String skipValidUrl;

    private String privateKeyPath;
    private String publicKeyPath;
    private String issuer;
    private String JwtCacheKey;
}



