package com.example.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

//    @Bean(name="mySqlFriendsDB")
    @Bean
    @ConfigurationProperties(prefix = "spring.dbfriends")
    @Primary
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }

//    @Bean(name="jdbcFriendsService")
//    @Autowired
//    public JdbcTemplate jdbcFriendsDBTemplate(@Qualifier("mySqlFriendsDB") DataSource mysqlDataSource) {
//        return new JdbcTemplate(mysqlDataSource);
//    }
}
