package com.example.logabckdesensitization.logbackadvice;

import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.ConsoleAppender;

/**
 * @Description: 控制台脱敏
 * @Author wanggl
 * @Date 2024/5/4 14:32
 */
public class SensitiveConsoleAppender extends ConsoleAppender {
    @Override
    protected void subAppend(Object event) {
        DesensitizationAppender appender = new DesensitizationAppender();
        appender.operation((LoggingEvent)event);
        super.subAppend(event);
    }
}
