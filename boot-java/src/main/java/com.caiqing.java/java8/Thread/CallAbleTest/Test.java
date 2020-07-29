package com.caiqing.java.java8.Thread.CallAbleTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/7/16 16:23
 **/
public class Test {

    public static void main(String[] args) {

        //创建Callable实现类的实现，
        Callable ticket = new Ticket();
        //使用FutureTask类包装Callable对象，该FutureTask对象封装了Callable对象的Call方法的返回值
        FutureTask futureTask = new FutureTask(ticket);

        new Thread(futureTask).start();

        try {
            //获取返回值
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
