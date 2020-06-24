package com.caiqing.java.设计模式.创建型.工厂方法模式;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/23 19:00
 **/
public class SystemLoggerFactory implements LoggerFactory{
    @Override
    public LoggerProduct getLoggerProduct() {
        SystemLoggerProduct systemLoggerProduct = new SystemLoggerProduct();
        systemLoggerProduct.printLogger();
        return systemLoggerProduct;
    }
}
