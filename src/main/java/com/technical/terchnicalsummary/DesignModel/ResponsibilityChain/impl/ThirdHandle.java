package com.technical.terchnicalsummary.DesignModel.ResponsibilityChain.impl;

import com.technical.terchnicalsummary.DesignModel.ResponsibilityChain.AbstractHandle;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description
 * @Author yushuai
 * @Date 2023/5/12 15:27
 **/
@Slf4j
public class ThirdHandle extends AbstractHandle {
    @Override
    public int handle() {
        int score = play();
        if (score >= 80) {
            log.error("评分100,已通关！");
        }

        return score;
    }

    public int play() {
        return 100;
    }
}
