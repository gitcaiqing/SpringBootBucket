package com.caiqing.java.设计模式.行为型.备忘录模式;

import org.apache.tools.ant.taskdefs.condition.Or;

import javax.swing.text.Caret;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/7/13 15:05
 **/
public class Test {

    public static void main(String[] args) {

        //发起人
        Originator originator = new Originator();

        //管理者
        Caretaker caretaker = new Caretaker();

        originator.setState("A");
        System.out.println("初始状态："+originator.getState());
        caretaker.setMemento(originator.createMemento());

        originator.setState("B");
        System.out.println("新状态："+originator.getState());

        //恢复原来状态
        originator.restoreMemento(caretaker.getMemento());
        System.out.println("新状态："+originator.getState());

    }
}
