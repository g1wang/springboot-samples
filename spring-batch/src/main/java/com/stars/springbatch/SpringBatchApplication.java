package com.stars.springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBatchApplication implements CommandLineRunner {

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job csvProcessingJob;

    public static void main(String[] args) {
        SpringApplication.run(SpringBatchApplication.class, args);
    }


    /**
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        JobParameters params = new JobParametersBuilder()
                .addString("inputFile", "classpath:employees.csv")
                .addLong("startAt", System.currentTimeMillis())
                .toJobParameters();
        jobLauncher.run(csvProcessingJob, params);

    }
}
