package com.caiqing.java.设计模式.行为型.观察模式;

import com.caiqing.java.设计模式.结构型.外观模式.SubSystem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Description 具体目标
 * 它实现抽象目标中的通知方法，当具体主题的内部状态发生改变时，通知所有注册过的观察者对象。
 * @Author CQ
 * @Date 2020/7/7 17:29
 **/
public class ConcreteSubject extends Subject {

    //通知所有观察者
    @Override
    void notifyObserver() {
        for(Observer observer : observers){
            observer.response();
        }
    }
}
