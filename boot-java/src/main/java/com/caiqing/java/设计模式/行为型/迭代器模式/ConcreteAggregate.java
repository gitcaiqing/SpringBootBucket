package com.caiqing.java.设计模式.行为型.迭代器模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 具体聚合类
 * @Author CQ
 * @Date 2020/7/8 16:10
 **/
public class ConcreteAggregate implements Aggregate {

    private List<Object> objects = new ArrayList<>();

    @Override
    public void add(Object object) {
        objects.add(object);
    }

    @Override
    public void remove(Object object) {
        objects.remove(object);
    }

    @Override
    public Iterator getIterator() {
        return(new ConcreteIterator(objects));
    }
}
