package com.caiqing.java.设计模式.行为型.迭代器模式;


/**
 * @Description 抽象聚合类
 * @Author CQ
 * @Date 2020/7/8 16:09
 **/
public interface Aggregate {

    public void add(Object object);

    public void remove(Object object);

    public Iterator getIterator();
}
