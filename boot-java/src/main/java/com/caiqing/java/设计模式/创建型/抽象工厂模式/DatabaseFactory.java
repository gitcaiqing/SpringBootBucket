package com.caiqing.java.设计模式.创建型.抽象工厂模式;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/23 19:00
 **/
public class DatabaseFactory implements LoggerFactory {
    @Override
    public LoggerProduct getLoggerProduct() {
        DatabaseLoggerProduct databaseLoggerProduct = new DatabaseLoggerProduct();
        databaseLoggerProduct.printLogger();
        return databaseLoggerProduct;
    }

    @Override
    public FileProduct getFileProduct() {
        DatabaseFileProduct databaseFileProduct = new DatabaseFileProduct();
        databaseFileProduct.printFile();
        return databaseFileProduct;
    }
}
