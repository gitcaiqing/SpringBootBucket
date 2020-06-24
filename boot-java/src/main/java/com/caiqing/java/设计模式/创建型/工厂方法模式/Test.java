package com.caiqing.java.设计模式.创建型.工厂方法模式;

/**
 * @Description 工厂方法模式:定义一个用于创建对象的接口,但是让子类决定将哪一个类实例化。工厂方法模式让一个类的实例化延迟到其子类。
 * @Author CQ
 * @Date 2020/6/23 19:07
 **/
public class Test {
    public static void main(String[] args) {
        LoggerFactory loggerFactory = new DatabaseLoggerFactory();
        LoggerProduct databaseLoggerProduct = loggerFactory.getLoggerProduct();
        System.out.println(databaseLoggerProduct);

        LoggerFactory loggerFactory1 = new SystemLoggerFactory();
        LoggerProduct systemLoggerProduct = loggerFactory1.getLoggerProduct();
        System.out.println(systemLoggerProduct);
    }
}
