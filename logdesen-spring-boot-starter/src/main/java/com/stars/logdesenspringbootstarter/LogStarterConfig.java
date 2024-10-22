package com.stars.logdesenspringbootstarter;

import lombok.Data;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/9/14 15:33
 */
@Data
public class LogStarterConfig {
    private LogStarterProperties logStarterProperties;
    private String name;

    public LogStarterConfig(LogStarterProperties logStarterProperties) {
        this.logStarterProperties = logStarterProperties;
    }

    public String getUserName() {
        return "todo"+name;
    }
}
