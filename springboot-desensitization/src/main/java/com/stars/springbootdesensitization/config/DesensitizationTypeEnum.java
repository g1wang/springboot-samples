package com.stars.springbootdesensitization.config;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2025/5/15 14:56
 */
public enum DesensitizationTypeEnum {
    //自定义
    MY_RULE,
    //用户名
    USER_NAME,
    //用户id
    USER_ID,
    //中文名
    CHINESE_NAME,
    //身份证号
    ID_CARD,
    //座机号
    FIXED_PHONE,
    //手机号
    MOBILE_PHONE,
    //地址
    ADDRESS,
    //电子邮件
    EMAIL,
    //密码
    PASSWORD,
    //中国大陆车牌，包含普通车辆、新能源车辆
    CAR_LICENSE,
    //银行卡
    BANK_CARD
}
