package com.example.auditlog.aspect;

import cn.hutool.json.JSONUtil;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: V2 增加参数获取
 * @Author wanggl
 * @Date 2024/10/22 19:45
 */
@Component
@Aspect
@Slf4j
public class AuditLogAspectV2 {

    // 方式1 execution
    @Pointcut("execution(public * com.example.*.web.*.*(..))")
    //方式2 使用自定义注解类的，进入切面
    //@Pointcut("@annotation(com.example.auditlog.aspect.AuditLog)")
    public void auditLogPointCut() {
    }

    @Around("auditLogPointCut()")
    public Object auditLog(ProceedingJoinPoint joinPoint) throws Throwable {

        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
        // 获取请求头
        String uaHeader = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(uaHeader);
        StringBuffer sb = new StringBuffer();
        sb.append("\n【浏览器类型】：").append(userAgent.getBrowser().toString());
        sb.append("\n【操作系统】：").append(userAgent.getOperatingSystem());
        sb.append("\n【原始User-Agent】：").append(uaHeader);
        sb.append("\n【源IP】：").append(getIp(request));
        sb.append("\n【请求头】：").append(request.getHeader("apiKey"));
        sb.append("\n【url】：").append(request.getRequestURL().toString());
        // 获取请求参数
        sb.append("\n【请求类型】：").append(request.getMethod());
        sb.append("\n【请求类名】：").append(joinPoint.getSignature().getDeclaringTypeName());
        sb.append("\n【请求方法名】：").append(joinPoint.getSignature().getName());
        sb.append("\n【queryString】：").append(request.getQueryString());
        sb.append("\n【requestBody】：").append(JSONUtil.toJsonStr(joinPoint.getArgs()));
        long startTime = System.currentTimeMillis();
        Object rs;
        boolean successAble = false;
        String responseStr = null;
        try {
            rs = joinPoint.proceed();
            responseStr = JSONUtil.toJsonStr(rs);
            successAble = true;
        } finally {
            sb.append("\n【请求结果】：").append(successAble);
            sb.append("\n【请求响应值】：").append(responseStr);
            sb.append("\n【请求响应时间】：").append(System.currentTimeMillis() - startTime);
            log.info(sb.toString());
        }
        // 响应参数
        return rs;
    }

    @AfterThrowing(pointcut = "auditLogPointCut()", throwing = "ex")
    public void logException(JoinPoint joinPoint, Throwable ex) {
        // 获取方法名和异常信息
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();

        log.info("Exception in " + className + "." + methodName + "(): " + ex.getMessage());

        // 可以在此处记录日志、发送通知、做事务处理等
    }

    private String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;

    }

}
