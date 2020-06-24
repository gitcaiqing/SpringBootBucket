package com.caiqing.java.设计模式.创建型.抽象工厂模式;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/23 18:59
 **/
public interface LoggerFactory {

    LoggerProduct getLoggerProduct();

    FileProduct getFileProduct();
}
