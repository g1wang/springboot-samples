package com.stars.springmvc.authorization.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**  
* @Author laboratory
* @Description 在Controller的方法参数中使用此注解，该方法在映射时会注入当前登录的User对象
* @Date 10:41 2023/1/9  
* @Param   
* @return   
**/
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CurrentUser {
}
