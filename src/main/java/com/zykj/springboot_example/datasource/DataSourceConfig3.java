package com.zykj.springboot_example.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.zykj.springboot_example.datasource3.dao",
        annotationClass = Repository.class,
        sqlSessionFactoryRef = "sqlSessionFactory3")
public class DataSourceConfig3 {

    @Bean("dataSource3")
    @ConfigurationProperties(prefix = "spring.datasource.datasource3")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("sqlSessionFactory3")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("dataSource3") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mappers/datasource3/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean("dataSourceTransactionManager3")
    public DataSourceTransactionManager testDataSourceTransactionManager(@Qualifier("dataSource3") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("sqlSessionTemplate3")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("sqlSessionFactory3") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
