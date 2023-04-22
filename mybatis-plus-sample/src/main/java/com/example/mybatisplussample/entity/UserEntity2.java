package com.example.mybatisplussample.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author laboratory
 * @Date 2022/10/26 17:03
 */
@Data
@TableName(value = "user_info", schema = "recsys1")
public class UserEntity2 {
    @TableId(type = IdType.AUTO)
    private Integer userId;
    private SexEnum sexEnum;
    private Integer age;
    private BigDecimal score;
}

