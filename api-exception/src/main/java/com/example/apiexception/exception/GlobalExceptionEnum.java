package com.example.apiexception.exception;

import lombok.Getter;

@Getter
public enum GlobalExceptionEnum {

    ERROR("-1", "系统异常,请稍后再试!"),

    SUCCESS("0", "操作成功!"),

    PARAM_ERROR("1002", "参数校验异常"),

    DELETE_ERROR("1101", "删除错误"),

    UPLOAD_ERROR("1102", "上传文件失败错误"),
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
