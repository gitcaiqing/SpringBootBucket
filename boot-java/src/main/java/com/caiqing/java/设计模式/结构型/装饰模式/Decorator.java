package com.caiqing.java.设计模式.结构型.装饰模式;

/**
 * @Description 抽象装饰
 * @Author CQ
 * @Date 2020/6/29 15:45
 **/
public class Decorator implements Component{

    public Component component;

    public Decorator(Component component){
        this.component = component;
    }

    @Override
    public void biu() {
        System.out.println("抽象装饰 biu");
    }
}
