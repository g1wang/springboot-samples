package com.example.mybatisplussample.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum SexEnum {
    MALE(1,"男"),
    FEMALE(0,"女");
    @EnumValue
    private final Integer code;
    private final String descp;

    SexEnum(Integer code, String descp) {
        this.code = code;
        this.descp = descp;
    }
}
