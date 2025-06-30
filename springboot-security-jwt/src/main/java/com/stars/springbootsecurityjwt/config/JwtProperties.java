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
    private Long expiration;
    private String issuer;


    public Long getExpiration() {
        return expiration;
    }

    public void setExpiration(Long expiration) {
        this.expiration = expiration;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
}



