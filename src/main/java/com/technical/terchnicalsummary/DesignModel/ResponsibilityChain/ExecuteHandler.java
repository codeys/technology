package com.technical.terchnicalsummary.DesignModel.ResponsibilityChain;

import com.technical.terchnicalsummary.DesignModel.ResponsibilityChain.impl.FirstHandle;
import com.technical.terchnicalsummary.DesignModel.ResponsibilityChain.impl.SecondHandle;
import com.technical.terchnicalsummary.DesignModel.ResponsibilityChain.impl.ThirdHandle;

/**
 * @Description
 * @Author yushuai
 * @Date 2023/5/12 15:28
 **/
public class ExecuteHandler {
    public static void main(String[] args) {
        AbstractHandle first = new FirstHandle();
        AbstractHandle second = new SecondHandle();
        AbstractHandle third = new ThirdHandle();

        first.setNextObject(second);
        second.setNextObject(third);

        first.handle();
    }
}
