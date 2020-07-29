package com.caiqing.java.java8.Thread.CallAbleTest;

import java.util.concurrent.Callable;

/**
 * @Description 实现Callable，重新call方法
 * @Author CQ
 * @Date 2020/7/16 16:23
 **/
public class Ticket implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("实现Callable，重新call方法 创建线程....");
        return "call 方法 返回了头羊";
    }
}
