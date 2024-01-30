package com.ricksnrz.primerapirest.dataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource.db2")
public class Db2DataSourceConfig extends DataSourceProperties {

    @Bean(name = "db2DataSource")
    public DataSource dataSource() {
        return new DriverManagerDataSource(getUrl(), getUsername(), getPassword());
    }
}