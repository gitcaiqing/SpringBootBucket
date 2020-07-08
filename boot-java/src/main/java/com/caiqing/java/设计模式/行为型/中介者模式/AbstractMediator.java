package com.caiqing.java.设计模式.行为型.中介者模式;

/**
 * @Description 抽象中介者类
 * @Author CQ
 * @Date 2020/7/8 14:16
 **/
public abstract class AbstractMediator {

    //持有各个具体的同事类
    protected Purchase purchase;

    protected Stock stock;

    protected Sale sale;

    AbstractMediator(Purchase purchase, Stock stock, Sale sale){
        this.purchase = purchase;
        this.stock = stock;
        this.sale = sale;
    }

    public abstract void execute(String str, Object... objects);
}
