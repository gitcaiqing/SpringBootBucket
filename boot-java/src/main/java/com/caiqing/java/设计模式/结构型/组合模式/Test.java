package com.caiqing.java.设计模式.结构型.组合模式;

import java.math.BigDecimal;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/7/2 11:00
 **/
public class Test {

    public static void main(String[] args) {
        Bags bigBags, smallBags;
        Goods goods;

        bigBags = new Bags("大袋子");
        smallBags = new Bags("小袋子");

        goods = new Goods("辣条", 5L, 103L);
        bigBags.add(goods);
        smallBags.add(goods);

        goods = new Goods("薯片", 2L , 502L);
        bigBags.add(goods);
        smallBags.add(goods);

        goods = new Goods("鱼干", 2L , 1000L);
        bigBags.add(goods);

        goods = new Goods("面条", 3L , 250L);
        bigBags.add(goods);


        bigBags.add(smallBags);

        System.out.println("选购的商品：");
        bigBags.show();
        System.out.println("选购的商品总价："+ bigBags.calculation().doubleValue() + "毛" );
        System.out.println("选购的商品总价："+ bigBags.calculation().doubleValue()/100 + "元");


    }
}
