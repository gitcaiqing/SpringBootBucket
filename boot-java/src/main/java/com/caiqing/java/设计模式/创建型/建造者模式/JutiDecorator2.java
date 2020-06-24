package com.caiqing.java.设计模式.创建型.建造者模式;

/**
 * @Description 具体的建造工人2
 * @Author CQ
 * @Date 2020/6/24 14:17
 **/
public class JutiDecorator2 extends Decorator {

    @Override
    public void buildWall() {
        keting.setWall("墙2");
    }

    @Override
    public void buildTv() {
        keting.setTv("电视2");
    }

    @Override
    public void buildSofa() {
        keting.setSofa("沙发2");
    }
}
