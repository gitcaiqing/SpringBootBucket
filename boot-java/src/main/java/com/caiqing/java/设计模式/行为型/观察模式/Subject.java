package com.caiqing.java.设计模式.行为型.观察模式;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Description 抽象模板
 * @Author CQ
 * @Date 2020/7/7 17:27
 **/
public abstract class Subject {

    protected List<Observer> observers = new ArrayList<>();

    public void add(Observer observer){
        observers.add(observer);
    }

    public void remove(Observer observer){
        observers.remove(observer);
    }

    abstract void notifyObserver();

}
