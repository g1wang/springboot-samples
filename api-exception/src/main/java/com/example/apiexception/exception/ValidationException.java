package com.example.apiexception.exception;

/**
 * 校验异常
 */
public class ValidationException extends GlobalException {

    public ValidationException(String msg) {
        super(GlobalExceptionEnum.VALID_ERROR.getCode(), msg);
    }

}
