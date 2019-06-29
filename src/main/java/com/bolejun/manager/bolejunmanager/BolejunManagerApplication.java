package com.bolejun.manager.bolejunmanager;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;

@SpringBootApplication
@ComponentScan(basePackages = "com.bolejun.manager.bolejunmanager")
@MapperScan(basePackages = "com.bolejun.manager.bolejunmanager.dao")
public class BolejunManagerApplication {

    @Value("${druid.datasource.url}")
    private String url;

    @Value("${druid.datasource.username}")
    private String username;

    @Value("${druid.datasource.password}")
    private String password;

    @Value("${druid.datasource.driverClassName}")
    private String driverName;

    public static void main(String[] args) {
        SpringApplication.run(BolejunManagerApplication.class, args);
    }

    @Bean
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverName);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setUrl(url);
        return druidDataSource;
    }
}
