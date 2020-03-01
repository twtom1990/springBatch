package com.tom.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


/**
 * Created with Tang Wei
 * Description:
 * User: SEELE
 * Date: 2020-02-22
 * Time: 17:57
 */
@Configuration
public class DataSourceConfig {
    @Primary
    @Bean(name = "dataSourceBatch")
    @ConfigurationProperties(prefix = "spring.datasource-batch")
    public DataSource dataSourceBatch() {
        return  DataSourceBuilder.create().build();
    }

    @Bean(name = "dataSourceDocuments")
    @ConfigurationProperties(prefix = "spring.datasource-documents")
    public DataSource dataSourceDocuments() {
        return  DataSourceBuilder.create().build();
    }

}
