package com.example.cachedoubleclear.api;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/10/21 20:04
 */

import java.lang.annotation.*;

/**
 *延时双删
 **/
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.METHOD)
public @interface ClearAndReloadCache {
    String name() default "";
}
