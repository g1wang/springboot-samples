package com.stars.springmvc.authorization.config;

/**
* @Author laboratory
* @Description
* @Date 17:02 2022/12/21
* @Param
* @return
**/
public class Constants {

    /**
     * 存储当前登录用户id的字段名
     */
    public static final String CURRENT_USER_ID = "CURRENT_USER_ID";

    /**
     * token有效期（小时）
     */
    public static final int TOKEN_EXPIRES_HOUR = 72;

    /**
     * 存放Authorization的header字段
     */
    public static final String AUTHORIZATION = "authorization";

}
