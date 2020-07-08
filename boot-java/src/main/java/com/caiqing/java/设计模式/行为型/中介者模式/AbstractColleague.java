package com.caiqing.java.设计模式.行为型.中介者模式;

/**
 * @Description 抽象同事类
 * @Author CQ
 * @Date 2020/7/8 14:15
 **/
public abstract class AbstractColleague {

    //维护一个抽象中介类
    protected AbstractMediator mediator;

    public AbstractMediator getMediator() {
        return mediator;
    }

    public void setMediator(AbstractMediator mediator) {
        this.mediator = mediator;
    }
}
