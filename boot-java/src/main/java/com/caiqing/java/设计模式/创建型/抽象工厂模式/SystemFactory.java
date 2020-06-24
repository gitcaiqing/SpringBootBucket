package com.caiqing.java.设计模式.创建型.抽象工厂模式;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/23 19:00
 **/
public class SystemFactory implements LoggerFactory {
    @Override
    public LoggerProduct getLoggerProduct() {
        SystemLoggerProduct systemLoggerProduct = new SystemLoggerProduct();
        systemLoggerProduct.printLogger();
        return systemLoggerProduct;
    }

    @Override
    public FileProduct getFileProduct() {
        SystemFileProduct systemFileProduct = new SystemFileProduct();
        systemFileProduct.printFile();
        return systemFileProduct;
    }
}
