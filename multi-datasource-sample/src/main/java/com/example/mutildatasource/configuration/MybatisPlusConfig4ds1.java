package com.example.mutildatasource.configuration;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Description:
 * @Author laboratory
 * @Date 2022/11/12 10:04
 */
@Configuration
@MapperScan(basePackages ="com.example.mutildatasource.ds1.**.mapper",
        sqlSessionTemplateRef = "ds1SqlSessionTemplate")
public class MybatisPlusConfig4ds1 {

    @Bean(name = "dataSource1")
    @ConfigurationProperties(prefix = "spring.datasource.ds1")
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    //主数据源 ds1数据源
    @Primary
    @Bean("ds1SqlSessionFactory")
    public SqlSessionFactory ds1SqlSessionFactory(@Qualifier("dataSource1") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().
                getResources("classpath*:com/example/mutildatasource/ds1/**/*.xml"));
        return sqlSessionFactory.getObject();
    }

    @Primary
    @Bean(name = "ds1TransactionManager")
    public DataSourceTransactionManager ds1TransactionManager(@Qualifier("dataSource1") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name = "ds1SqlSessionTemplate")
    public SqlSessionTemplate ds1SqlSessionTemplate(@Qualifier("ds1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
