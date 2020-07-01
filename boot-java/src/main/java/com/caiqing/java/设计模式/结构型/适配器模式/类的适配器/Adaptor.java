package com.caiqing.java.设计模式.结构型.适配器模式.类的适配器;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/29 13:35
 **/
public class Adaptor extends Adaptee implements Target{
    @Override
    public void request() {
        super.doSomething();
    }
}
