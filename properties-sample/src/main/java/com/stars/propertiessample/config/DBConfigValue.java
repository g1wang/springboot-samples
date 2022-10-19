package com.stars.propertiessample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description: @PropertySource+@Value注解读取方式
 * @Author laboratory
 * @Date 2022/10/19 14:53
 */
@Component
@PropertySource(value = {"config/db-config.properties"})
public class DBConfigValue {

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
