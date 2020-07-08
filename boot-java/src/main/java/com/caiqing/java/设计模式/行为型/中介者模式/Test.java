package com.caiqing.java.设计模式.行为型.中介者模式;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/7/8 14:15
 **/
public class Test {

    public static void main(String[] args) {
        Purchase purchase = new Purchase();
        Stock stock = new Stock();
        Sale sale = new Sale();

        AbstractMediator abstractMediator = new ConcreteMediator(purchase, stock, sale);

        purchase.setMediator(abstractMediator);
        stock.setMediator(abstractMediator);
        sale.setMediator(abstractMediator);

        String name = "铅笔";
        purchase.buy(name, 1);
    }
}
