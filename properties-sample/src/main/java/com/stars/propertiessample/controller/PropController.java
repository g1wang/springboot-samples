package com.stars.propertiessample.controller;

import com.stars.propertiessample.config.DBConfigProp;
import com.stars.propertiessample.config.DBConfigValue;
import com.stars.propertiessample.config.InfoConfigProp;
import com.stars.propertiessample.config.InfoConfigValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author laboratory
 * @Date 2022/10/19 14:42
 */
@RestController
@RequestMapping("prop")
public class PropController {

    @Resource
    InfoConfigValue infoConfigValue;

    @Resource
    InfoConfigProp infoConfigProp;

    @Resource
    DBConfigValue dbConfigValue;
    @Resource
    DBConfigProp dbConfigProp;

    @GetMapping("value")
    public String getByValue(){
        return infoConfigValue.getTitle();
    }

    @GetMapping("configurationProperties")
    public String getByConfigurationProperties(){
        return infoConfigProp.getCompany();
    }

    @GetMapping("dbname-value")
    public String getDBNameValue(){
        return dbConfigValue.getUsername();
    }

    @GetMapping("dbpasswd-prop")
    public String getDBPasswdValue(){
        return dbConfigProp.getPassword();
    }

}
