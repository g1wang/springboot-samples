package com.example.mvcapiresult.aspect;

import com.example.mvcapiresult.api.response.R;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ResultAspect {
    @Around("@annotation(com.example.mvcapiresult.annotation.ResultHandler)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (ConstraintViolationException cve) {
            return R.error(cve.getMessage());
        } catch (Exception e) {
            return R.error(e.getMessage());
        }
        return proceed;
    }
}

