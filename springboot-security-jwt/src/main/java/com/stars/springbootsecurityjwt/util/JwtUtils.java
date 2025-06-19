package com.stars.springbootsecurityjwt.util;

import com.stars.springbootsecurityjwt.config.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.security.Key;
import java.security.PublicKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author wanggl
 * @Date 2025/6/6 17:20
 */
public class JwtUtils {


    /**
     * @return
     * @Author wanggl
     * @Description 非对称加密 RSA
     * @Date 16:44 2025/6/12
     * @Param [token, publicKey]
     **/
    public static Map<String, Object> getClaims(String token, PublicKey publicKey) {
        JwtParser parser = getParser(publicKey);
        return getClaimsFromToken(token, parser);
    }

    /**
     * @return
     * @Author wanggl
     * @Description 对称加密HS
     * @Date 16:44 2025/6/12
     * @Param [token, secretKey]
     **/
    public static Map<String, Object> getClaims(String token, SecretKey secretKey) {
        JwtParser parser = getParser(secretKey);
        return getClaimsFromToken(token, parser);
    }

    /**
     * @return
     * @Author wanggl
     * @Description 从令牌中获取userid
     * @Date 14:07 2025/6/12
     * @Param []
     **/
    public static String getSubject(String token, PublicKey publicKey) {
        JwtParser parser = getParser(publicKey);
        return getSubject(token, parser);
    }

    /**
     * @return
     * @Author wanggl
     * @Description 从令牌中获取userid
     * @Date 14:07 2025/6/12
     * @Param []
     **/
    public static String getSubject(String token, SecretKey secretKey) {
        JwtParser parser = getParser(secretKey);
        return getSubject(token, parser);
    }

    /**
     * @return
     * @Author wanggl
     * @Description 从令牌中获取userid
     * @Date 14:07 2025/6/12
     * @Param []
     **/
    private static String getSubject(String token, JwtParser jwtParser) {
        String subject = null;
        Claims claims = getClaimsFromToken(token, jwtParser);
        if (claims != null) {
            subject = claims.getSubject();
        }
        return subject;
    }

    public static String generateToken(String subject, String roles, Key secretKey) {
        long nowMillis = System.currentTimeMillis();
        // 创建私有声明
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", roles);
        // 使用 JJWT 的 Builder 模式创建 Token
        String jwt = Jwts.builder()
                .subject(subject) // 设置主题，通常是用户名或用户ID
                .issuer(JwtProperties.getIssuer()) // 设置签发者
                .issuedAt(new Date(nowMillis)) // 设置签发时间
                .expiration(new Date(nowMillis + JwtProperties.getExpiration()))
                .claims(claims) // 添加自定义的私有声明
                .signWith(secretKey)  // 使用密钥进行签名
                .compact(); // 构建并序列化为紧凑的字符串格式
        return jwt;
    }



    /**
     * @return
     * @Author wanggl
     * @Description 获取解析器
     * @Date 16:07 2025/6/12
     * @Param [token, publicKey]
     **/
    private static JwtParser getParser(PublicKey publicKey) {
        return Jwts.parser()
                .verifyWith(publicKey)   // 必须设置签名密钥
                .requireIssuer(JwtProperties.getIssuer())  // (可选) 要求签发者必须是 "MyAuthServer"
                .build();
    }

    /**
     * @return
     * @Author wanggl
     * @Description 获取解析器
     * @Date 16:07 2025/6/12
     * @Param [token, publicKey]
     **/
    private static JwtParser getParser(SecretKey secretKey) {
        return Jwts.parser()
                .verifyWith(secretKey)   // 必须设置签名密钥
                .requireIssuer(JwtProperties.getIssuer())  // (可选) 要求签发者必须是 "MyAuthServer"
                .build();
    }

    /**
     * RSA 从令牌中获取数据声明,验证 JWT 签名
     *
     * @param token     令牌
     * @param jwtParser
     * @return 数据声明
     */
    private static Claims getClaimsFromToken(String token, JwtParser jwtParser) {
        // 解析 Token。如果任何校验失败，这里会直接抛出异常。
        Jws<Claims> claimsJws = jwtParser.parseSignedClaims(token);
        // 如果成功解析，可以安全地获取声明
        return claimsJws.getPayload();
    }

}

