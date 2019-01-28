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
@MapperScan(basePackages = "com.zykj.springboot_example.datasource1.dao",
        annotationClass = Repository.class,
        sqlSessionFactoryRef = "sqlSessionFactory1")
public class DataSourceConfig1 {

    @Bean("dataSource1")
    @ConfigurationProperties(prefix = "spring.datasource.datasource1")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("sqlSessionFactory1")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("dataSource1") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mappers/datasource1/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean("dataSourceTransactionManager1")
    public DataSourceTransactionManager testDataSourceTransactionManager(@Qualifier("dataSource1") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean("sqlSessionTemplate1")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("sqlSessionFactory1") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
