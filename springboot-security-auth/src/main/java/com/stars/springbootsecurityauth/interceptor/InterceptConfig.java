package com.stars.springbootsecurityauth.interceptor;

import com.stars.springbootsecurityjwt.config.JwtProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description:
 * @Author wanggl
 * @Date 2023/11/23 20:16
 */

@Configuration
public class InterceptConfig implements WebMvcConfigurer {
    @Autowired
    JwtInterceptor jwtInterceptor;
    @Autowired
    JwtProperties  jwtProperties;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
        registry.addInterceptor(jwtInterceptor)
                //拦截的路径 需要进行token验证的路径
                .addPathPatterns()
                //放行的路径
                .excludePathPatterns(jwtProperties.getWhiteList());
    }
}
