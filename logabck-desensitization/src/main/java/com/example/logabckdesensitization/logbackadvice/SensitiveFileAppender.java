package com.example.logabckdesensitization.logbackadvice;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.FileAppender;

/**
 * @Description: SensitiveFileAppender
 * @Author wanggl
 * @Date 2024/5/4 14:34
 */
public class SensitiveFileAppender extends FileAppender {
    @Override
    protected void subAppend(Object event) {
        DesensitizationAppender appender = new DesensitizationAppender();
        appender.operation((LoggingEvent) event);
        super.subAppend(event);
    }
}
