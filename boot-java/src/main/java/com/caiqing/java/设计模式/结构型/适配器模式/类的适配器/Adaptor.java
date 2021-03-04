package com.caiqing.java.设计模式.结构型.适配器模式.类的适配器;

/**
 * @Description 适配器类 继承适配者类实现目标类 访问
 * @Author CQ
 * @Date 2020/6/29 13:35
 **/
public class Adaptor extends Adaptee implements Target{
    /**
     * 按目标类的访问方式 访问适配者类
     */
    @Override
    public void request() {
        super.doSomething();
    }
}
