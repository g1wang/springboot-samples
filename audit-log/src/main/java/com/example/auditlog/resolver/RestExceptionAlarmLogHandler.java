package com.example.auditlog.resolver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/11/8 16:30
 */
@Slf4j
//@Component
public class RestExceptionAlarmLogHandler extends AbstractHandlerExceptionResolver {
    /**
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return
     */
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
       log.info("第一个处理开始");
        return new ModelAndView("nicuola");
    }


}
