package com.caiqing.java.设计模式.结构型.代理模式.动态代理.jdk动态代理;

import com.caiqing.java.设计模式.结构型.代理模式.RealSubject;
import com.caiqing.java.设计模式.结构型.代理模式.Subject;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/28 13:15
 **/
public class Test {

    public static void main(String[] args) {
        Subject proxy = (Subject) new JdkDynamicProxy().getProxy(new RealSubject());
        proxy.request();
    }
}
