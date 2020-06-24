package com.caiqing.java.设计模式.创建型.建造者模式;

/**
 * @Description 抽象 建造工人
 *
 * @Author CQ
 * @Date 2020/6/24 14:12
 **/
public abstract class Decorator {

    protected Keting keting = new Keting();

    //有建造 墙 电视 沙发 方法
    public abstract void buildWall();

    public abstract void buildTv();

    public abstract void buildSofa();

    //有最终建造产品的返回方法
    public Keting getResult(){
        return keting;
    }
}
