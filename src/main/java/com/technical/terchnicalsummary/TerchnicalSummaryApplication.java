package com.technical.terchnicalsummary;

import com.technical.terchnicalsummary.utils.SpringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@MapperScan(basePackages = {"com.technical.terchnicalsummary.mapper"})
//@EnableGlobalMethodSecurity(securedEnabled=true,prePostEnabled = true)
public class TerchnicalSummaryApplication {

    public static void main(String[] args) {
        System.out.println("服务启动开始。。。");
        ConfigurableApplicationContext applicationContext = SpringApplication.run(TerchnicalSummaryApplication.class, args);
        SpringUtils.setApplicationContext(applicationContext);
        System.out.println("服务启动结束。。。");
    }

}
