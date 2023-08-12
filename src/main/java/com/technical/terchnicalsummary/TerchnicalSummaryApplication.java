package com.technical.terchnicalsummary;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.technical.terchnicalsummary.utils.SpringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@MapperScan(basePackages = {"com.technical.terchnicalsummary.mapper"})
//@EnableGlobalMethodSecurity(securedEnabled=true,prePostEnabled = true)
//@EnableRedisHttpSession
//@EnableJdbcHttpSession
public class TerchnicalSummaryApplication {

    public static void main(String[] args) {
        System.out.println("服务启动开始。。。");
        ConfigurableApplicationContext applicationContext = SpringApplication.run(TerchnicalSummaryApplication.class, args);
        SpringUtils.setApplicationContext(applicationContext);
        System.out.println("服务启动成功。。。");
    }

}
