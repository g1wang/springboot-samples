package com.stars.springbootdesensitization.dbdesen.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 
 * @TableName card_info
 */
@TableName(value ="card_info")
@Data
public class CardInfo {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String idNo;

    /**
     * 
     */
    private String finshellCardNo;

    /**
     * 
     */
    private String description;
}