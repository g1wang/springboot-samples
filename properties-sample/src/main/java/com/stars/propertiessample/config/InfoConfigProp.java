package com.stars.propertiessample.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description: @ConfigurationProperties注解读取方式
 * @Author l
 * @Date 2022/10/19 14:47
 */
@Component
@ConfigurationProperties(prefix = "info")
@PropertySource(value = {"config/db-config.properties"})
public class InfoConfigProp {
    private String title;
    private String company;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
