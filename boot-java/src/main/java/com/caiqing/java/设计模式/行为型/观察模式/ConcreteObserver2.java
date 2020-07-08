package com.caiqing.java.设计模式.行为型.观察模式;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/7/7 17:32
 **/
public class ConcreteObserver2 implements Observer{
    @Override
    public void response() {
        System.out.println("具体2观察者被通知，做出反应");
    }
}
