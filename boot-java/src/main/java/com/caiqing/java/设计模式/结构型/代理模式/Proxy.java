package com.caiqing.java.设计模式.结构型.代理模式;

/**
 * @Description 代理类 实现和真实主题相同的接口，在请求方法创建真实主题的引用，并调用真实主题方法，实现代理
 *
 * 真实主题必须存在，可以使用动态代理解决
 * @Author CQ
 * @Date 2020/6/24 17:48
 **/
public class Proxy implements Subject{

    RealSubject realSubject;

    @Override
    public void request() {
        if(realSubject == null){
            realSubject = new RealSubject();
        }
        System.out.println("访问真实主题之前.......");

        realSubject.request();

        System.out.println("访问真实主题之后........");
    }
}
