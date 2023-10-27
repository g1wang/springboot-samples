package com.example.apiexception.exception;

import lombok.Data;

@Data
public class GlobalException extends RuntimeException{
    private String code;
    private String globalMessage;

    public GlobalException(String code, String message) {
        super(message);
        this.code = code;
        this.globalMessage = message;
    }

    // 建立直接传入枚举做参数可以直接创建对应的异常
    public GlobalException(GlobalExceptionEnum globalExceptionEnum) {
        super(globalExceptionEnum.getMessage());
        this.code = globalExceptionEnum.getCode();
        this.globalMessage = globalExceptionEnum.getMessage();
    }
}
