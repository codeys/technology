package com.technical.terchnicalsummary.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceB {

    @Autowired
    JdbcTemplate jdbcTemplate;

//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void B() throws InterruptedException {
//        String sql = "select * from user";
//        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql);
//        System.out.println(JSON.toJSONString(stringObjectMap));
        String sql = "update user_copy set name='6' where code = 'n1' ";
        jdbcTemplate.update(sql);
        Thread.sleep(3000);
//        int a = 1/0;
    }

}
