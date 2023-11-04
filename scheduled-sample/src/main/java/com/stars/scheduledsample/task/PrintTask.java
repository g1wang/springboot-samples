package com.stars.scheduledsample.task;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
* @Author laboratory  
* @Description 定时器demo
* @Date 14:05 2022/9/21
**/
@Component
@ConditionalOnProperty(prefix = "scheduled", name = "enabled", havingValue = "true")
public class PrintTask {

    @Scheduled(cron = "${scheduled.printCron}")
    private void doTask(){
        System.out.println("print:"+new Date());
    }
}
