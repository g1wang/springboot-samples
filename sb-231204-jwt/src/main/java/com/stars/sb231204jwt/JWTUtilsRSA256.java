package com.stars.sb231204jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Calendar;
import java.util.Map;

/**
 * @Description:
 * @Author wanggl
 * @Date 2023/9/6 14:15
 */
public class JWTUtilsRSA256 {

    final JwkStore jwkStore = new JwkStore("{JWKS_FILE_HOST}");
    private static PublicKey publicKey = null;
    private static PrivateKey privateKey = null;

    public static String getToken(Map<String, String> map) throws Exception {
        JWTCreator.Builder builder = JWT.create();
        //payload
        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });
        Calendar instance = Calendar.getInstance();
        // 默认3天过期
        instance.add(Calendar.DATE, 3);
        // 指定令牌的过期时间
        builder.withExpiresAt(instance.getTime());
        Resource resource = new ClassPathResource("rsa-public.cert");
        return builder.sign(Algorithm.RSA256(privateKey);
    }

    /**
     * 验证token 合法性
     */
    public static DecodedJWT verify(String token) {
        //如果有任何验证异常，此处都会抛出异常
        return JWT.require(Algorithm.RSA256(publicKey)).build().verify(token);
    }
}
