package com.caiqing.java.设计模式.行为型.备忘录模式;

/**
 * @Description 管理者
 * 对备忘录进行管理，提供保存与获取备忘录的功能，但其不能对备忘录的内容进行访问与修改。
 * @Author CQ
 * @Date 2020/7/13 15:06
 **/
public class Caretaker {

    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
