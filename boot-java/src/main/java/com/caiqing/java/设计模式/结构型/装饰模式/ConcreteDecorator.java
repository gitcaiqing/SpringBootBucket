package com.caiqing.java.设计模式.结构型.装饰模式;

/**
 * @Description 具体装饰类
 * @Author CQ
 * @Date 2020/6/29 15:46
 **/
public class ConcreteDecorator extends Decorator{

    public ConcreteDecorator(Component component){
        super(component);
    }

    @Override
    public void biu() {
        System.out.println("ready go");
        this.component.biu();
    }
}
