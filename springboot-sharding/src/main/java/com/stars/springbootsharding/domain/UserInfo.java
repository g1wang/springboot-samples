package com.stars.springbootsharding.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @TableName user_info
 */
@TableName(value ="user_info")
@Data
public class UserInfo {
    /**
     * 
     */
    @TableId
    private Long userId;

    /**
     * 
     */
    private Integer sex;

    /**
     * 
     */
    private Integer age;

    /**
     * 
     */
    private BigDecimal score;

    /**
     * 
     */
    private Integer deleted;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private Integer version;
}