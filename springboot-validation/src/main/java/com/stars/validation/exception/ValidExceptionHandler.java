package com.stars.validation.exception;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidExceptionHandler {

    @ExceptionHandler(BindException.class)
    public String validExceptionHandler(BindException bindException){
        return bindException.getBindingResult().getAllErrors().get(0).getDefaultMessage();
    }

}
