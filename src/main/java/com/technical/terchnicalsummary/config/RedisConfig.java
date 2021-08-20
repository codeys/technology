package com.technical.terchnicalsummary.config;
/*
 * @ClassName RedisConfig
 * @Description redis配置
 * @Author shuai_yu
 * @Date 2021/8/4 14:23
 **/

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // key采用String的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        // hash的key也采用String的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        // value序列化方式采用jackson
        template.setValueSerializer(stringRedisSerializer);
        // hash的value序列化方式采用jackson
        template.setHashValueSerializer(stringRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

    @Bean(name="redisTwo")
    public RedisTemplate<String, Object> getRedisTemplate(
            @Value("${spring.redis-two.host}") String hostName,
            @Value("${spring.redis-two.password}") String password,
            @Value("${spring.redis-two.port}") int port,
            @Value("${spring.redis-two.database}") int database,
            @Value("${spring.redis-two.pool.max-active}") int maxActive,
            @Value("${spring.redis-two.pool.max-idle}") int maxIdle,
            @Value("${spring.redis-two.pool.min-idle}") int minIdle,
            @Value("${spring.redis-two.pool.max-wait}") long maxWait) {

        RedisConnectionFactory factory = this.getRedisConnectionFactory(
                hostName, password, port, maxActive, maxIdle, minIdle, maxWait,
                database); // 建立Redis的连接
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setConnectionFactory(factory);
        // key采用String的序列化方式
        redisTemplate.setKeySerializer(stringRedisSerializer);
        // hash的key也采用String的序列化方式
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        // value序列化方式采用jackson
        redisTemplate.setValueSerializer(stringRedisSerializer);
        // hash的value序列化方式采用jackson
        redisTemplate.setHashValueSerializer(stringRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    public RedisConnectionFactory getRedisConnectionFactory(String hostName,
                                                            String password, int port, int maxActive, int maxIdle, int minIdle,
                                                            long maxWait, int database) { // 是负责建立Factory的连接工厂类
        JedisConnectionFactory jedisFactory = new JedisConnectionFactory();
        jedisFactory.setHostName(hostName);
        jedisFactory.setPort(port);
        jedisFactory.setPassword(password);
        jedisFactory.setDatabase(database);

        JedisPoolConfig poolConfig = new JedisPoolConfig(); // 进行连接池配置
        poolConfig.setMaxTotal(maxActive);
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxWaitMillis(maxWait);
        jedisFactory.setPoolConfig(poolConfig);
        jedisFactory.afterPropertiesSet(); // 初始化连接池配置
        return jedisFactory;
    }
}
