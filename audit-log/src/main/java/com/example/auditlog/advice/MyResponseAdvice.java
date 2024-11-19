package com.example.auditlog.advice;


import com.alibaba.fastjson.JSON;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/11/18 11:01
 */
@RestControllerAdvice
public class MyResponseAdvice implements ResponseBodyAdvice {

    // 返回一个 boolean 值，true 表示返回数据之前对数据进行重写，也就是会进入 beforeBodyWrite 方法
    // 返回 false 表示对结果不进行任何处理，直接返回
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    // 方法返回之前调用此方法
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        //加密
        return null;
    }


}
