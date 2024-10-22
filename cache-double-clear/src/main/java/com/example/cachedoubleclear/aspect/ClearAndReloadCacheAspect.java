package com.example.cachedoubleclear.aspect;

import com.example.cachedoubleclear.api.ClearAndReloadCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.Redisson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/10/21 20:05
 */
@Aspect
@Component
public class ClearAndReloadCacheAspect {
    @Resource
    Redisson redisson;

    /**
     * 切入点
     * 切入点,基于注解实现的切入点  加上该注解的都是Aop切面的切入点
     */

    @Pointcut("@annotation(com.example.cachedoubleclear.api.ClearAndReloadCache)")
    public void pointCut() {

    }

    /**
     * 环绕通知
     * 环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值。
     * 环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     *
     * @param proceedingJoinPoint
     */
    @Around("pointCut()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("----------- 环绕通知 -----------");
        System.out.println("环绕通知的目标方法名：" + proceedingJoinPoint.getSignature().getName());

        Signature signature1 = proceedingJoinPoint.getSignature();
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();

        MethodSignature methodSignature = (MethodSignature) signature1;
        Method targetMethod = methodSignature.getMethod();//方法对象
        ClearAndReloadCache annotation = targetMethod.getAnnotation(ClearAndReloadCache.class);//反射得到自定义注解的方法对象

        String name = annotation.name();//获取自定义注解的方法对象的参数即name
//        Set<String> keys1 = stringRedisTemplate.keys("*" + name + "*");//模糊删除
//        stringRedisTemplate.delete(keys1);
        //redisson.getKeys().deleteByPattern("*" + name + "*");//模糊删除redis的key值
        redisson.getKeys().deleteByPattern(name);//删除redis的key值

        //执行加入双删注解的改动数据库的业务 即controller中的方法业务
        Object proceed = null;
        try {
            proceed = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        //开一个线程 延迟1秒（此处是1秒举例，可以改成自己的业务）
        // 在线程中延迟删除  同时将业务代码的结果返回 这样不影响业务代码的执行
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                redisson.getKeys().deleteByPattern(name);//删除redis的key值
                System.out.println("-----------1秒钟后，在线程中延迟删除完毕 -----------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        return proceed;//返回业务代码的值
    }
}
