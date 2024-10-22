package com.stars.logdesenspringbootstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/9/14 15:30
 */
@Configuration
// EnableConfigurationProperties value数组中的配置类起作用
@EnableConfigurationProperties(value = {LogStarterProperties.class})
public class LogStarterAutoConfiguration {
    @Autowired
    private LogStarterProperties logStarterProperties;

    @Bean
    @ConditionalOnMissingBean(LogStarterConfig.class)
    public LogStarterConfig logStarterProperties(){
        return new LogStarterConfig(logStarterProperties);
    }


}
