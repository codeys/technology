package com.technical.terchnicalsummary.config.elastic;
/*
 * @ClassName ElasticConfig
 * @Description elastic配置类
 * @Author shuai_yu
 * @Date 2021/8/17 11:10
 **/

import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpPost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticConfig {

    @Autowired
    ElasticProperties elasticProperties;

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(RestClient.builder(
                new HttpHost(elasticProperties.getHost(),elasticProperties.getPort())));
        return restHighLevelClient;
    }
}
