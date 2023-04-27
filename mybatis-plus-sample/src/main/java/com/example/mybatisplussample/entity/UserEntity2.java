package com.example.mybatisplussample.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @Description:
 * @Author laboratory
 * @Date 2022/10/26 17:03
 */
@Data
@TableName(value = "user_info")
public class UserEntity2 {
    @OrderBy
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
    private Timestamp ts;
    private Integer userId;
    private Integer sex;
    private String age;
    private String score;
}

