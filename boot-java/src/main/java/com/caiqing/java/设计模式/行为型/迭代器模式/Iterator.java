package com.caiqing.java.设计模式.行为型.迭代器模式;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/7/8 16:12
 **/
public interface Iterator {

    Object first();

    Object next();

    boolean hasNext();
}
