package com.caiqing.java.设计模式.创建型.工厂方法模式;

/**
 * @Description 继承日志产品抽象类 实现打印日志，打印数据库日志
 * @Author CQ
 * @Date 2020/6/23 19:02
 **/
public class DatabaseLoggerProduct extends LoggerProduct{
    @Override
    public void printLogger() {
        System.out.println("打印数据库日志.....");
    }
}
