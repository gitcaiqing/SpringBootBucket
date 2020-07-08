package com.caiqing.java.设计模式.行为型.中介者模式;

import java.util.Objects;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/7/8 14:29
 **/
public class ConcreteMediator extends AbstractMediator {


    ConcreteMediator(Purchase purchase, Stock stock, Sale sale) {
        super(purchase, stock, sale);
    }

    @Override
    public void execute(String str, Object... objects) {
        if("purchase".equals(str)){
            this.buy(objects);
        }else if("stock".equals(str)){
            this.stock(objects);
        }else if("sale".equals(str)){

        }
    }

    private void buy(Object[] objects){
        String name = (String)objects[0];
        int num =(int) objects[1];

        System.out.println("采购："+name +" "+num+"件");

        this.stock(objects);
    }

    private void stock(Object[] objects){
        String name = (String)objects[0];
        int num =(int) objects[1];
        super.stock.increase(name, num);
    }
}
