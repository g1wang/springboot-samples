package com.stars.springbootdesensitization.apidesensitization.vo;

import com.stars.springbootdesensitization.apidesensitization.config.Desensitization;
import com.stars.springbootdesensitization.apidesensitization.config.DesensitizationTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2025/5/15 15:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestPojo {
    @Desensitization(type = DesensitizationTypeEnum.CHINESE_NAME)
    private String userName;

    @Desensitization(type = DesensitizationTypeEnum.MOBILE_PHONE)
    private String phone;

    @Desensitization(type = DesensitizationTypeEnum.PASSWORD)
    private String password;

    //@Desensitization(type = DesensitizationTypeEnum.MY_RULE, startInclude = 0, endExclude = 2)
    @Desensitization(type = DesensitizationTypeEnum.ADDRESS)
    private String address;
}
