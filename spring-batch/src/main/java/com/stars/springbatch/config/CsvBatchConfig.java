package com.stars.springbatch.config;

import com.stars.springbatch.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

/**
 * @Description:
 * @Author wanggl
 * @Date 2025/5/13 9:23
 */
@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class CsvBatchConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job csvProcessingJob(Step csvStep) {
        return jobBuilderFactory.get("csvProcessingJob")
                .incrementer(new RunIdIncrementer())
                .start(csvStep)
                .build();
    }

    @Bean
    public Step csvStep(ItemReader<Employee> csvReader,
                        ItemProcessor<Employee, Employee> salaryValidatorProcessor,
                        ItemWriter<Employee> consoleWriter) {
        return stepBuilderFactory.get("csvStep")
                .<Employee, Employee>chunk(10)
                .reader(csvReader)
                .processor(salaryValidatorProcessor)
                .writer(consoleWriter)
                .faultTolerant()
                .skipLimit(10)
                .skip(FlatFileParseException.class)
                .build();
    }
    @Bean
    @StepScope
    public FlatFileItemReader<Employee> csvReader(
            @Value("#{jobParameters['inputFile']}") Resource resource) {

        return new FlatFileItemReaderBuilder<Employee>()
                .name("csvFileReader")
                .resource(resource)
                .linesToSkip(1) // 跳过标题行
                .delimited()
                .delimiter(",")
                .names("id", "name", "age", "department", "salary")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(Employee.class);
                }})
                .strict(false) // 允许空行
                .build();
    }

    // 控制台输出
    @Bean
    public ItemWriter<Employee> consoleWriter() {
        return items -> items.forEach(item ->
                System.out.println("Processed: " + item));
    }

    // 数据库写入（可选）
    @Bean
    public JdbcBatchItemWriter<Employee> dbWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Employee>()
                .dataSource(dataSource)
                .sql("INSERT INTO employees (name, age, department, salary) " +
                        "VALUES (:name, :age, :department, :salary)")
                .beanMapped()
                .build();
    }


}
