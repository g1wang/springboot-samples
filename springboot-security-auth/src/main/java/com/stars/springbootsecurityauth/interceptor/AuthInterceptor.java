package com.stars.springbootsecurityauth.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stars.securityjwtspringbootstater.configration.util.JwtRSAUtils;
import com.stars.springbootsecurityauth.config.AuthConfigration;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
public class AuthInterceptor implements HandlerInterceptor {

    @Resource
    private JwtRSAUtils jwtRSAUtils;
    @Resource
    private AuthConfigration authConfigration;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String, String> map = new HashMap<>();
        //从http请求头获取token
        String token = request.getHeader(authConfigration.getHeader());
        if (token == null) {
            map.put("msg", "token is null");
        } else {
            try {
                //如果验证成功放行请求
                jwtRSAUtils.getClaims(token);
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
