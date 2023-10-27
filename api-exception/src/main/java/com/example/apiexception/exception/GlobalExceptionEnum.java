package com.example.apiexception.exception;

import lombok.Getter;

@Getter
public enum GlobalExceptionEnum {

    ERROR("E0001", "系统异常"),
    /**
     *参数校验异常
     */
    PARAM_ERROR("E1002", "参数校验异常"),
    VALID_ERROR("E2001",""),
    ;

    /**
     * 错误码
     */
    private String code;
    /**
     * 错误码对应的错误信息提示语
     */
    private String message;

    GlobalExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
