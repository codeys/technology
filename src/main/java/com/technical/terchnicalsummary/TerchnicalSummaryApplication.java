package com.technical.terchnicalsummary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@MapperScan(basePackages = {"com.technical.terchnicalsummary.mapper"})
//@EnableGlobalMethodSecurity(securedEnabled=true,prePostEnabled = true)
public class TerchnicalSummaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(TerchnicalSummaryApplication.class, args);
    }

}
