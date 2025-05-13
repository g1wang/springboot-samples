package com.stars.springbatch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2025/5/8 10:52
 */
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step stepHello() {
        return stepBuilderFactory.get("stepHello")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("Hello, Spring Batch!");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    @Bean
    public Step stepTransform() {
        return stepBuilderFactory.get("stepTransform")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("协议解析开始！ Spring Batch!");
                    return RepeatStatus.CONTINUABLE;
                })
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .tasklet((contribution, chunkContext) -> {
                    System.out.println("step1！ Spring Batch!");
                    return RepeatStatus.FINISHED;
                })
                .build();
    }

    /*@Bean
    public Job job3(Step step1) {
        return jobBuilderFactory.get("job3")
                .start(step1)
                .next(stepHello())
                .next(stepTransform())
                .build();
    }*/


}
