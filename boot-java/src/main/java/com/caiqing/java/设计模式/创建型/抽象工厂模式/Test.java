package com.caiqing.java.设计模式.创建型.抽象工厂模式;

/**
 * @Description 是一种为访问类提供一个创建一组相关或相互依赖对象的接口，且访问类无须指定所要产品的具体类就能得到同族的不同等级的产品的模式结构。
 * @Author CQ
 * @Date 2020/6/23 19:38
 **/
public class Test {

    public static void main(String[] args) {

        //实例化工厂
        DatabaseFactory databaseFactory = new DatabaseFactory();
        //打印数据库日志
        databaseFactory.getLoggerProduct();
        //打印数据库文件
        databaseFactory.getFileProduct();

        SystemFactory systemFactory = new SystemFactory();
        //打印系统日志
        systemFactory.getLoggerProduct();
        //打印系统文件
        systemFactory.getFileProduct();
    }
}
