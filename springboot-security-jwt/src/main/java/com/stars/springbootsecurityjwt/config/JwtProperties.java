package com.stars.springbootsecurityjwt.config;

/**
 * @Description:
 * @Author wanggl
 * @Date 2025/6/11 10:18
 */

public class JwtProperties {
    /**
     * accessToken 有效时间
     */
    private static Long expiration;
    /**
     * 前端向后端传递JWT时使用HTTP的header名称，前后端要统一
     */
    private static String header;
    private static String privateKeyPath;
    private static String publicKeyPath;
    private static String issuer;

    public JwtProperties(Long expiration, String header, String privateKeyPath, String publicKeyPath, String issuer, String jwtCacheKey) {
        this.expiration = expiration;
        this.header = header;
        this.privateKeyPath = privateKeyPath;
        this.publicKeyPath = publicKeyPath;
        this.issuer = issuer;
    }

    public static Long getExpiration() {
        return expiration;
    }

    public static String getHeader() {
        return header;
    }

    public static String getPrivateKeyPath() {
        return privateKeyPath;
    }

    public static String getPublicKeyPath() {
        return publicKeyPath;
    }

    public static String getIssuer() {
        return issuer;
    }
}



