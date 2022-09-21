package com.stars.scheduledsample.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;

/**
* @Author laboratory  
* @Description 定时器demo
* @Date 14:05 2022/9/21
**/
@Component
public class PrintTask {

    @Scheduled(cron = "${scheduled.printCron}")
    private void doTask(){
        System.out.println("print:"+new Date());
    }
}
