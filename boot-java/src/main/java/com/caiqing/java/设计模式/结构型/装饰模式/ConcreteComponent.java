package com.caiqing.java.设计模式.结构型.装饰模式;

/**
 * @Description 具体构件
 * @Author CQ
 * @Date 2020/6/29 15:44
 **/
public class ConcreteComponent implements Component{
    @Override
    public void biu() {
        System.out.println("具体构件 biu");
    }
}
