package com.example.mybatisplussample.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author laboratory
 * @Date 2022/10/26 17:03
 */
@Data
@TableName(value = "user_info")
public class UserEntity2 {
    @OrderBy
    @TableId(type = IdType.AUTO)
    private Integer userId;
    @TableField("sex")
    private SexEnum sexEnum;
    private Integer age;
    private BigDecimal score;
}

