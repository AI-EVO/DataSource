package com.aievo.demo.config;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DbConfig {
    @Bean
    @Primary
    public DataSource getDataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("jack");
        ds.setPassword("Password123!");
        ds.setPortNumber(1433);
        ds.setDatabaseName("jackdemo");
        ds.setServerName("jackdemo.database.windows.net");
        ds.setEncrypt(true);
        ds.setTrustServerCertificate(false);
        dataSource.setAutoCommit(true);
        dataSource.setMaximumPoolSize(8);
        dataSource.setMinimumIdle(2);
        dataSource.setDataSource(ds);
        return dataSource;
    }
}
