package com.technical.terchnicalsummary.DesignModel.ResponsibilityChain;

/**
 * @Description 抽象处理者
 * @Author yushuai
 * @Date 2023/5/12 15:21
 **/
public abstract class AbstractHandle {

    // 下一个责任链对象
    protected AbstractHandle nextObject;

    public void setNextObject(AbstractHandle nextObject) {
        this.nextObject = nextObject;
    }

    public abstract int handle();
}
