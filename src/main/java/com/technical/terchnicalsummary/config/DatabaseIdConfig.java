package com.technical.terchnicalsummary.config;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/*
 * @ClassName DatabaseIdConfig
 * @Description 多数据库支持
 * @Author shuai_yu
 * @Date 2021/7/14 11:05
 **/
@Configuration
public class DatabaseIdConfig {

    @Bean
    public DatabaseIdProvider getDatabaseIdProvider() {
        DatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
        Properties properties = new Properties();
        properties.setProperty("Oracle", "oracle");
        properties.setProperty("MySQL", "mysql");
        databaseIdProvider.setProperties(properties);
        return databaseIdProvider;
    }

}
