package com.caiqing.java.设计模式.行为型.模板方法模式;

import sun.security.jgss.spi.MechanismFactory;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/7/2 15:21
 **/
public class Test {

    public static void main(String[] args) {
        MeCook meCook = new MeCook();
        meCook.cook();

        WifeCook wifeCook = new WifeCook();
        wifeCook.cook();
    }
}
