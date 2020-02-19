package com.event.bootspringevent.controller;

import com.event.bootspringevent.entity.Order;
import com.event.bootspringevent.event.MyEvent;
import com.event.bootspringevent.service.OrderService;
import com.event.bootspringevent.util.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event/order")
@Slf4j
public class OrderEventController {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    public ResultModel createOrder(){
        Order order = orderService.createOrder();
        return new ResultModel(order);
    }

    @PostMapping("/createOrderWithEvent")
    public ResultModel createOrderWithEvent(){
        Order order = orderService.createOrderWithEvent();
        return new ResultModel(order);
    }
}

