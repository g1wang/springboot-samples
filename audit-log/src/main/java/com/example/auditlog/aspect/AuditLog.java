package com.example.auditlog.aspect;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuditLog {
    /**
     * 操作内容
     */
    String operation();

    /**
     * 操作类型
     */
    String operationType();

    /**
     * 日志类型
     */
    String logType();

    /**
     * 应用类型
     */
    String appType();
}
