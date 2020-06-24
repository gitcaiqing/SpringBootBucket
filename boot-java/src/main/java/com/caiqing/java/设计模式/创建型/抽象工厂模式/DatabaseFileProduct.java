package com.caiqing.java.设计模式.创建型.抽象工厂模式;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/6/24 11:02
 **/
public class DatabaseFileProduct implements FileProduct{
    @Override
    public void printFile() {
        System.out.println("打印数据库文件");
    }
}
