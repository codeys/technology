package com.technical.terchnicalsummary;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.technical.terchnicalsummary.mapper.UserMapper;
import com.technical.terchnicalsummary.model.User;
import com.technical.terchnicalsummary.service.IBuy;
import com.technical.terchnicalsummary.service.impl.Boy;
import com.technical.terchnicalsummary.utils.ElasticUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@SpringBootTest
class TerchnicalSummaryApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
        System.out.println(userMapper.getUserCount());
    }

    @Test
    void insertData(){
        User user = new User();
        user.setId("4");
        user.setUserName("王新");
        user.setUserAge("27");
        user.setGender("1");
        userMapper.insertUser(user);
    }

    @Test
    void getData() {
        PageHelper.startPage(1, 2);
        List<User> userByPage = userMapper.getUserByPage();
        PageInfo<User> pageInfo = new PageInfo<>(userByPage);
        System.out.println(JSON.toJSONString(pageInfo));
    }

    @Test
    void aop(){
        IBuy boy = new Boy();
        String buyResult = boy.buy();
        log.info("结果：" + buyResult);
    }

    @Resource(name="redisTwo")
    RedisTemplate redisTemplate;
    @Autowired
    @Qualifier("redisTemplate")
    RedisTemplate redisTemplate0;
    @Test
    void testRedis() {
        redisTemplate.opsForValue().set("name","yushuai");
        redisTemplate0.opsForValue().set("name","lisi");
    }

    @Autowired
    ElasticUtils elasticUtils;
    @Test
    void elastic() {
        elasticUtils.createIndex("user");
//        elasticUtils.deleteIndex("user");
    }

}
