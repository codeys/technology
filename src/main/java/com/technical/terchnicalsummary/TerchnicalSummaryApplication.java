package com.technical.terchnicalsummary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.technical.terchnicalsummary.mapper"})
public class TerchnicalSummaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(TerchnicalSummaryApplication.class, args);
    }

}
