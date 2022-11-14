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
@MapperScan(basePackages ="com.example.mutildatasource.ds2.**.mapper",
        sqlSessionTemplateRef = "ds2SqlSessionTemplate")
public class MybatisPlusConfig4ds2 {

    @Bean(name = "dataSource2")
    @ConfigurationProperties(prefix = "spring.datasource.ds2")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    //主数据源 ds1数据源

    @Bean("ds2SqlSessionFactory")
    public SqlSessionFactory ds1SqlSessionFactory(@Qualifier("dataSource2") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().
                getResources("classpath*:com/example/mutildatasource/ds2/**/*.xml"));
        return sqlSessionFactory.getObject();
    }

    @Bean(name = "ds2TransactionManager")
    public DataSourceTransactionManager ds1TransactionManager(@Qualifier("dataSource2") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "ds2SqlSessionTemplate")
    public SqlSessionTemplate ds1SqlSessionTemplate(@Qualifier("ds2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
