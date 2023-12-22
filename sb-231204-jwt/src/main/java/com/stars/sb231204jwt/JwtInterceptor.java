package com.stars.sb231204jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2023/11/23 20:14
 */

public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HashMap<String, String> map=new HashMap<>();
        //从http请求头获取token
        String token = request.getHeader("token");
        try {
            //如果验证成功放行请求
            DecodedJWT verify = JwtUtils.verify(token);
            return true;
        }
        catch (Exception exception)
        {
            map.put("msg","验证失败："+exception);
        }
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json:charset=UTF=8");
        response.getWriter().println(json);
        return false;
    }
}
