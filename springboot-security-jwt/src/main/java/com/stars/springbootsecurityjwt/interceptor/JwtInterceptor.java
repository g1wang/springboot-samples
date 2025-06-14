package com.stars.springbootsecurityjwt.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stars.springbootsecurityjwt.config.KeyManager;
import com.stars.springbootsecurityjwt.util.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author wanggl
 * @Date 2023/11/23 20:14
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    JwtUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, String> map = new HashMap<>();
        //从http请求头获取token
        String token = request.getHeader("token");
        if (token == null) {
            map.put("msg", "token is null");
        } else {
            try {
                //如果验证成功放行请求
                jwtUtils.validateToken(token, KeyManager.getPublicKey());
                return true;
            } catch (Exception exception) {
                map.put("msg", "验证失败：" + exception);
            }
        }
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
        return false;
    }
}
