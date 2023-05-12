package com.technical.terchnicalsummary.DesignModel.ResponsibilityChain.impl;

import com.technical.terchnicalsummary.DesignModel.ResponsibilityChain.AbstractHandle;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description
 * @Author yushuai
 * @Date 2023/5/12 15:23
 **/
@Slf4j
public class FirstHandle extends AbstractHandle {
    @Override
    public int handle() {
        int score = play();
        if (score >= 80) {
            log.error("评分80,进入下一关！");
            this.nextObject.handle();
        }

        return score;
    }

    public int play() {
        return 80;
    }
}
