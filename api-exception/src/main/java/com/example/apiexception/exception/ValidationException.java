package com.example.apiexception.exception;

import com.example.apiexception.exception.GlobalException;
import com.example.apiexception.exception.GlobalExceptionEnum;

public class ValidationException extends GlobalException {

    public ValidationException(String msg) {
        super(GlobalExceptionEnum.VALID_ERROR.getCode(), msg);
    }

}
