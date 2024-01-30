package com.ricksnrz.primerapirest.dataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource.db1")
public class Db1DataSourceConfig extends DataSourceProperties {

    @Bean(name = "db1DataSource")
    @Primary
    public DataSource dataSource() {
        return new DriverManagerDataSource(getUrl(), getUsername(), getPassword());
    }
}
