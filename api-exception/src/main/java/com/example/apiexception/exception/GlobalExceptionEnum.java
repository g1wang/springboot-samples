package com.example.apiexception.exception;

import lombok.Getter;

@Getter
public enum GlobalExceptionEnum {

    /**
     * 系统异常
     */
    ERROR("-1", "系统异常,请稍后再试!"),
    /**
     *参数校验异常
     */
    PARAM_ERROR("1002", "参数校验异常"),
    VALID_ERROR("2001",""),
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
