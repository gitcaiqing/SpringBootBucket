package com.event.bootspringevent.service;

import com.event.bootspringevent.entity.Order;

import javax.transaction.Transactional;

public interface OrderService {

    //普通下单
    Order createOrder();

    //下单后通过事件驱动进行业务解耦
    Order createOrderWithEvent(Boolean isAsync);

    //下单后通过事件驱动进行业务解耦
    Order createOrderWithGenericEvent(Boolean isAsync);
}
