package com.stars.springbootsecurityauth.util;

import com.stars.springbootsecurityjwt.util.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2025/6/19 17:25
 */
public class AuthUtils {

    /**
     * @return
     * @Author wanggl
     * @Description 从令牌中获取userid
     * @Date 14:07 2025/6/12
     * @Param []
     **/
    public static String getUserIdFromToken(String token, JwtParser jwtParser) {
        String userId = null;
        Claims claims = JwtUtils.getClaims(token, jwtParser);
        if (claims != null) {
            userId = claims.getSubject();
        }
        return userId;
    }
}
