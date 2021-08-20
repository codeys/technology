package com.technical.terchnicalsummary.service.impl;
/*
 * @ClassName Boy
 * @Description 男孩
 * @Author shuai_yu
 * @Date 2021/7/12 9:55
 **/

import com.technical.terchnicalsummary.service.IBuy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Boy implements IBuy {
    @Override
    public String buy() {
        log.info("男孩买了衣服！");
        return "男孩";
    }
}
