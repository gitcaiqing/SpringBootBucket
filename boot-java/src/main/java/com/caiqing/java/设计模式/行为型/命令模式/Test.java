package com.caiqing.java.设计模式.行为型.命令模式;

import java.io.Writer;
import java.nio.channels.WritableByteChannel;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/7/7 14:15
 **/
public class Test {

    public static void main(String[] args) {

        //客户点炒粉
        System.out.println("客户点炒粉");
        BreakFast chaoFen = new ChaoFen();

        //服务员下单
        System.out.println("服务员下单");
        Waiter waiter = new Waiter();
        waiter.setBreakFast(chaoFen);

        waiter.choseChaoFen();
    }
}
