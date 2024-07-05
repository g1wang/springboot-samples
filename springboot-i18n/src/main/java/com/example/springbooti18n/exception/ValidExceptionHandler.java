package com.example.springbooti18n.exception;

import com.example.springbooti18n.configration.I18nUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@RequiredArgsConstructor
public class ValidExceptionHandler {

    private final HttpServletRequest request;

    @ExceptionHandler(BindException.class)
    public String validExceptionHandler(BindException bindException){
//        return bindException.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return buildMsg(bindException);
    }

    /**
     * 参数校验不通过
     *
     * @param e MethodArgumentNotValidException
     * @return ResultVo<Void>
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return buildMsg(e.getBindingResult());
    }

    /**
     * 构建参数错误提示信息
     *
     * @param bindingResult BindingResult
     * @return String
     */
    private String buildMsg(BindingResult bindingResult) {
        StringBuilder builder = new StringBuilder(32);
        for (FieldError error : bindingResult.getFieldErrors()) {
            builder.append(", [").append(error.getField()).append(":")
                    .append(I18nUtil.getMessage(error.getDefaultMessage(),request.getHeader("lang"))).append("]");
        }

        return builder.substring(2);
    }

}
