package com.event.bootspringevent.event;

import com.event.bootspringevent.entity.Order;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/2/21 16:29
 **/
public class OrderCreateGenericEvent extends GenericEvent<Order>{

    public OrderCreateGenericEvent(Order order, Integer type){
        super(order, type);
    }
}
