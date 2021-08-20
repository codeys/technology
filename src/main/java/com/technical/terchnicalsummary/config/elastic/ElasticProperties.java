package com.technical.terchnicalsummary.config.elastic;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/*
 * @ClassName ElasticProperties
 * @Description elastic配置
 * @Author shuai_yu
 * @Date 2021/8/17 11:07
 **/
@Component
@PropertySource("classpath:/properties/elasticsearch.properties")
@ConfigurationProperties(prefix = "elastic")
@Data
public class ElasticProperties {
    private String host;
    private int port;
}
