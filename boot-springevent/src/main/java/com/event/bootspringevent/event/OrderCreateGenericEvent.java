package com.event.bootspringevent.event;

import com.event.bootspringevent.entity.Order;

/**
 * @Description 泛型事件具体实现-订单创建
 * @Author CQ
 * @Date 2020/2/21 16:29
 **/
public class OrderCreateGenericEvent extends GenericEvent<Order> {

    public OrderCreateGenericEvent(Order order, Integer type) {
        super(order, type);
    }
}
