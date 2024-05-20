package com.example.logabckdesensitization.logbackadvice;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.rolling.RollingFileAppender;

/**
 * @Description: SensitiveRollingFileAppender
 * @Author wanggl
 * @Date 2024/5/4 14:36
 */
public class SensitiveRollingFileAppender extends RollingFileAppender {
    @Override
    protected void subAppend(Object event) {
        DesensitizationAppender appender = new DesensitizationAppender();
        appender.operation((LoggingEvent)event);
        super.subAppend(event);
    }
}
