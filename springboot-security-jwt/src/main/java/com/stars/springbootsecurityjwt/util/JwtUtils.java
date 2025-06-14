package com.stars.springbootsecurityjwt.util;

import com.stars.springbootsecurityjwt.config.JwtProperties;
import io.jsonwebtoken.*;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.security.PublicKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author wanggl
 * @Date 2025/6/6 17:20
 */
@Component
@Slf4j
public class JwtUtils {

    private  final String ACCESS_TOKEN = "access_token";
    private  final String REFRESH_TOKEN = "refresh_token";
    @Resource
    private  JwtProperties jwtProperties;
    @Resource
    private  RedissonClient redissonClient;

    /**
    * @Author wanggl
    * @Description 非对称加密 RSA
    * @Date 16:44 2025/6/12
    * @Param [token, publicKey]
    * @return
    **/
    public  boolean validateToken(String token, PublicKey publicKey) {
        JwtParser parser = getParser(publicKey);
        return validateToken(token, parser);
    }

    /**
    * @Author wanggl
    * @Description 对称加密HS
    * @Date 16:44 2025/6/12
    * @Param [token, secretKey]
    * @return
    **/
    public  boolean validateToken(String token, SecretKey secretKey) {
        JwtParser parser = getParser(secretKey);
        return validateToken(token, parser);
    }

    private  boolean validateToken(String token, JwtParser jwtParser) {
        String userId = getUserIdFromToken(token, jwtParser);
        // 从redis缓存获取token
        String jwt = (String) redissonClient.getMapCache(jwtProperties.getJwtCacheKey() + userId).get(ACCESS_TOKEN);
        if (jwt == null || !jwt.equals(token)) {
            throw new RuntimeException("token no found");
        }
        return true;
    }

    public  String generateToken(String userId, String roles, Key secretKey) {
        long nowMillis = System.currentTimeMillis();
        // 创建私有声明
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", roles);
        // 使用 JJWT 的 Builder 模式创建 Token
        String jwt = Jwts.builder()
                .subject(userId) // 设置主题，通常是用户名或用户ID
                .issuer(jwtProperties.getIssuer()) // 设置签发者
                .issuedAt(new Date(nowMillis)) // 设置签发时间
                .expiration(new Date(nowMillis + jwtProperties.getExpiration()))
                .claims(claims) // 添加自定义的私有声明
                .signWith(secretKey)  // 使用密钥进行签名
                .compact(); // 构建并序列化为紧凑的字符串格式
        redissonClient.getMapCache(jwtProperties.getJwtCacheKey()+userId).put(ACCESS_TOKEN, jwt, jwtProperties.getExpiration(), TimeUnit.SECONDS);
        //redissonClient.getMapCache(jwtProperties.getJwtCacheKey()+userId).put(REFRESH_TOKEN, jwt, jwtProperties.getExpiration() * 2, TimeUnit.SECONDS);
        return jwt;
    }

    /**
     * @return
     * @Author wanggl
     * @Description 从令牌中获取userid
     * @Date 14:07 2025/6/12
     * @Param []
     **/
    public  String getUserIdFromToken(String token, JwtParser jwtParser) {
        String userId = null;
        Claims claims = getClaimsFromToken(token, jwtParser);
        if (claims != null) {
            userId = claims.getSubject();
        }
        return userId;
    }

    /**
     * @return
     * @Author wanggl
     * @Description 获取解析器
     * @Date 16:07 2025/6/12
     * @Param [token, publicKey]
     **/
    private  JwtParser getParser(PublicKey publicKey) {
        return Jwts.parser()
                .verifyWith(publicKey)   // 必须设置签名密钥
                .requireIssuer(jwtProperties.getIssuer())  // (可选) 要求签发者必须是 "MyAuthServer"
                .build();
    }

    /**
     * @return
     * @Author wanggl
     * @Description 获取解析器
     * @Date 16:07 2025/6/12
     * @Param [token, publicKey]
     **/
    private  JwtParser getParser(SecretKey secretKey) {
        return Jwts.parser()
                .verifyWith(secretKey)   // 必须设置签名密钥
                .requireIssuer(jwtProperties.getIssuer())  // (可选) 要求签发者必须是 "MyAuthServer"
                .build();
    }

    /**
     * RSA 从令牌中获取数据声明,验证 JWT 签名
     *
     * @param token     令牌
     * @param jwtParser
     * @return 数据声明
     */
    private  Claims getClaimsFromToken(String token, JwtParser jwtParser) {
        Claims claims = null;
        try {
            // 解析 Token。如果任何校验失败，这里会直接抛出异常。
            Jws<Claims> claimsJws = jwtParser.parseSignedClaims(token);
            // 如果成功解析，可以安全地获取声明
            claims = claimsJws.getPayload();
        } catch (ExpiredJwtException e) {
            log.error("Validation Failed: Token has expired. {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Validation Failed: Token is malformed. {}", e.getMessage());
        } catch (SecurityException e) {
            // 包括 SignatureException
            log.error("Validation Failed: Signature validation failed. {}", e.getMessage());
        } catch (Exception e) {
            // 捕获所有其他可能的异常
            log.error("Validation Failed: An unexpected error occurred. {}", e.getMessage());
        }
        return claims;
    }

}

