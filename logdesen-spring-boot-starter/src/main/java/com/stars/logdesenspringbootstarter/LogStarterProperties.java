package com.stars.logdesenspringbootstarter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/9/14 15:28
 */
@ConfigurationProperties(prefix = "com.logdesen")
@Data
public class LogStarterProperties {
    private String name;

}
