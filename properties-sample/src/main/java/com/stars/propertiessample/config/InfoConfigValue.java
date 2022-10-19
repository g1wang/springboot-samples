package com.stars.propertiessample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description: @Value注解读取方式
 * @Author l
 * @Date 2022/10/19 14:32
 */
@Component
public class InfoConfigValue {
    @Value("${info.title}")
    private String title;
    @Value("${info.company}")
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
