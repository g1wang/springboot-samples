package com.stars.scheduledsample.task;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author laboratory
 * @Description 定时器demo
 * @Date 14:05 2022/9/21
 **/
@Component
public class XxljobPrintTask {

    @XxlJob("xxlPrintJobHandler")
    private void doTask() {
        XxlJobHelper.log("print:" + new Date());
    }
}
