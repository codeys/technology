package com.technical.terchnicalsummary.transaction;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TransactionService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    TransactionServiceB transactionServiceB;


//    @Transactional
    public void A() {
//        String sql = "update user set name='3' where code = 'n1' ";
//        jdbcTemplate.update(sql);
        try {
            transactionServiceB.B();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String sql = "select * from user_copy";
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql);
        System.out.println(JSON.toJSONString(stringObjectMap));
//        int a = 1/0;
    }


}
