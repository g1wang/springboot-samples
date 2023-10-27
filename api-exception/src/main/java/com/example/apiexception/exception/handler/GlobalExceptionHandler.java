package com.example.apiexception.exception.handler;

import com.example.apiexception.exception.GlobalException;
import com.example.apiexception.exception.GlobalExceptionEnum;
import com.example.apiexception.exception.response.R;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理系统异常
     * @return
     *
     */
    @ExceptionHandler(Exception.class)
    public R exceptionHandler(Exception e){
        return R.error(GlobalExceptionEnum.ERROR.getCode(), GlobalExceptionEnum.ERROR.getMessage());
    }

    /**
     * 处理自定义业务异常
     * @return
     *
     */
    @ExceptionHandler(GlobalException.class) //这句代码可以认为是trycatch中的catch
    public R globalExceptionHandler(GlobalException e){
        return R.error(e.getCode(), e.getGlobalMessage());
    }


    /**
     * 处理校验对象时候的异常MethodArgumentNotValidException
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R globalExceptionHandler(MethodArgumentNotValidException e){

        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        // map()：对于流的一些中间业务操作就用此方法
        // ObjectError::getDefaultMessage：我只要流中对象的defaultMessage
        // errors.stream().map(o->o.getDefaultMessage())
        // Collectors.joining(",")：joining只对字符串生效，用其他类型会报错,把所有的得到的字符串使用逗号进行隔开并组合成一个字符串
        String messages = errors.stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(","));
        return R.error(GlobalExceptionEnum.PARAM_ERROR.getCode(), messages);
    }

    /**
     * 处理校验接口参数时候的异常BindException
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public R globalExceptionHandler(BindException e){
        return R.error(GlobalExceptionEnum.PARAM_ERROR.getCode(), e.getAllErrors().get(0).getDefaultMessage());
    }
}
