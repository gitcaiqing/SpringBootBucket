package com.caiqing.java.thread;

public class VolatileTest extends Thread{

    volatile boolean flag = false;
    //boolean flag = false;
    int i = 0;

    public void run() {
        while (!flag) {
            i++;
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws Exception {
        VolatileTest vt = new VolatileTest();
        vt.start();
        Thread.sleep(20);
        vt.flag = true;
        System.out.println("stope" + vt.i);
    }
}
