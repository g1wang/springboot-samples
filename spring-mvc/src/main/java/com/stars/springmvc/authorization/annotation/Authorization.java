package com.stars.springmvc.authorization.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description:在Controller的方法上使用此注解，该方法在映射时会检查用户是否登录，未登录返回401错误
 * @Author laboratory
 * @Date 2022/12/21 17:02
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Authorization {
}
