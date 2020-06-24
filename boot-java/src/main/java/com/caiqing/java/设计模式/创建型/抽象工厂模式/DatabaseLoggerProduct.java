package com.caiqing.java.设计模式.创建型.抽象工厂模式;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/23 19:02
 **/
public class DatabaseLoggerProduct implements LoggerProduct {
    @Override
    public void printLogger() {
        System.out.println("打印数据库日志.....");
    }
}
