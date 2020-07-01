package com.caiqing.java.设计模式.结构型.享元模式;

/**
 * @Description 抽象享元角色
 * @Author CQ
 * @Date 2020/6/29 16:35
 **/
public interface Flyweight {

    //传入非享元角色
    void operation(UnSharedConcreteFlyweight unSharedConcreteFlyweight);
}
