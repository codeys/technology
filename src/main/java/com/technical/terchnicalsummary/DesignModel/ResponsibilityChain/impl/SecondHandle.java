package com.technical.terchnicalsummary.DesignModel.ResponsibilityChain.impl;

import com.technical.terchnicalsummary.DesignModel.ResponsibilityChain.AbstractHandle;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description
 * @Author yushuai
 * @Date 2023/5/12 15:26
 **/
@Slf4j
public class SecondHandle extends AbstractHandle {
    @Override
    public int handle() {
        int score = play();
        if (score >= 90) {
            log.error("评分90,进入下一关！");
            this.nextObject.handle();
        }

        return score;
    }

    public int play() {
        return 90;
    }
}
