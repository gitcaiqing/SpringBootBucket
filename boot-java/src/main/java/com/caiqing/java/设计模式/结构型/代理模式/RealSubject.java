package com.caiqing.java.设计模式.结构型.代理模式;

/**
 * @Description 具体主题
 * @Author CQ
 * @Date 2020/6/24 17:47
 **/
public class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("访问真实主题....");
    }
}
