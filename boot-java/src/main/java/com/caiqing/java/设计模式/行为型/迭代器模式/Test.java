package com.caiqing.java.设计模式.行为型.迭代器模式;

import java.util.Arrays;

/**
 * @Description
 * 1. 模式的结构
 * 迭代器模式主要包含以下角色。
 * 抽象聚合（Aggregate）角色：定义存储、添加、删除聚合对象以及创建迭代器对象的接口。
 * 具体聚合（ConcreteAggregate）角色：实现抽象聚合类，返回一个具体迭代器的实例。
 * 抽象迭代器（Iterator）角色：定义访问和遍历聚合元素的接口，通常包含 hasNext()、first()、next() 等方法。
 * 具体迭代器（Concretelterator）角色：实现抽象迭代器接口中所定义的方法，完成对聚合对象的遍历，记录遍历的当前位置。
 * @Author CQ
 * @Date 2020/7/8 16:08
 **/
public class Test {

    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add("高考1");
        aggregate.add("高考2");
        aggregate.add("高考3");
        aggregate.add("高考4");
        aggregate.add("高考5");
        System.out.println("聚合内容有:");
        Iterator it = aggregate.getIterator();
        while (it.hasNext()){
            System.out.println(it.next().toString());
        }
        Object first = it.first();
        System.out.println("first:"+first);
        Object next = it.next();
        System.out.println("next:"+next);
    }
}
