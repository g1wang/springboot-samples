package com.example.auditlog.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/10/22 19:45
 */
//@Component
@Aspect
@Slf4j
public class AuditLogAspect {

    // 方式1 execution
      @Pointcut("execution(public * com.example.*.web.*.*(..))")
    //方式2 使用自定义注解类的，进入切面
    //@Pointcut("@annotation(com.example.auditlog.aspect.AuditLog)")
    public void auditLogPointCut() {
    }

    @AfterReturning(returning = "tag", pointcut = "auditLogPointCut()")
    public void auditLog(JoinPoint joinPoint, Object tag) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Object[] agrs = joinPoint.getArgs();
        String name = null;
        // 如果传参包含类且包含name属性 取出name的内容
        for (Object object : agrs) {
            if (object == null) {
                continue;
            }
            Integer nameIndex = object.toString().indexOf("name=");
            if (nameIndex > 0) {
                name = object.toString().substring(nameIndex + "name=".length()).split(",")[0];
            }
        }
        AuditLog auditLog = signature.getMethod().getAnnotation(AuditLog.class);
        // 没有添加注释的不写入日志
        if (auditLog == null) {
            return;
        } else {
//            String userId = ApiUtils.currentUserId();//当前登录的机构ID。使用自己项目的
            String operation = auditLog.operation();
            if (name != null) {
                operation = operation + ",名称为:" + name;
            }
            String logType = auditLog.logType();
            String appType = auditLog.appType();
            String operationType = auditLog.operationType();
            //保存日志内容，自行替换自己的保存业务
            log.info("operation={},logType={},appType={},operationType={}", operation, logType, appType, operationType);
            // auditLogService.saveOperation(userId, operation, operationType, logType, appType);
        }
    }

}
