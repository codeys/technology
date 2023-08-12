package com.technical.terchnicalsummary.controller;

import com.alibaba.fastjson.JSON;
import com.technical.terchnicalsummary.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author yushuai
 * @Date 2023/6/23 9:06
 **/
@RestController
@Slf4j
public class RedisController {

    @Autowired
    RedisUtils redisUtils;

    @RequestMapping("/redisLock")
    public String redisLock() {
        String value = UUID.randomUUID().toString();

        try {
            boolean lockFlag = redisUtils.setNx("redis-lock", value, 30);
            if (lockFlag) {
                String productStoreNum = redisUtils.getObject("productStoreNum",String.class);
                if (productStoreNum== null && productStoreNum.equalsIgnoreCase("0")) {
                    log.error("已售罄");
                }
                int productStoreNumInt = Integer.parseInt(productStoreNum);
                productStoreNumInt = productStoreNumInt - 1;
                redisUtils.set("productStoreNum", productStoreNumInt + "");
                log.error("库存剩余：" + productStoreNumInt);
            }else {
                try {
//                    log.error("获取锁失败，等待1s");
                    Thread.sleep(1000);
                    redisLock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {

        }finally {
            if (value.equalsIgnoreCase(redisUtils.getObject("redis-lock",String.class))) {
                // 非原子性操作，使用lua可解决此问题
                redisUtils.del("redis-lock");
            }
        }
        return "success";
    }

    @Autowired
    RedissonClient redissonClient;
    @RequestMapping("/redissonLock")
    public String redissonLock() {
        // 获取RLock对象
        RLock redisLock = redissonClient.getLock("redissonLock");
        try {
            boolean lock = redisLock.tryLock(30, 10, TimeUnit.SECONDS);
            if (lock) {
                String productStoreNum = redisUtils.getObject("productStoreNum",String.class);
                if (productStoreNum== null || productStoreNum.equalsIgnoreCase("0")) {
                    log.error("已售罄");
                    return "已售罄";
                }
                int productStoreNumInt = Integer.parseInt(productStoreNum);
                productStoreNumInt = productStoreNumInt - 1;
                redisUtils.set("productStoreNum", productStoreNumInt + "");
                log.error("库存剩余：" + productStoreNumInt);
            }
        } catch (Exception e) {

        } finally {
            redisLock.unlock();
        }
        return "success";
    }

}
