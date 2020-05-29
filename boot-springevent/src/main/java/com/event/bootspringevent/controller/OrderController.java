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
public class OrderController {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    public ResultModel createOrder() {
        Order order = orderService.createOrder();
        return new ResultModel(order);
    }

    /**
     * 创建订单-事件发布-事件监听（同步）
     *
     * @param
     * @return com.event.bootspringevent.util.ResultModel
     * @author CQ
     * @date 2020/2/21 15:56
     */
    @PostMapping("/createOrderWithEventSync")
    public ResultModel createOrderWithEventSync() {
        Order order = orderService.createOrderWithEvent(false);
        return new ResultModel(order);
    }

    /**
     * 创建订单-事件发布-事件监听（异步）
     *
     * @param
     * @return com.event.bootspringevent.util.ResultModel
     * @author CQ
     * @date 2020/2/21 15:56
     */
    @PostMapping("/createOrderWithEventAsync")
    public ResultModel createOrderWithEventAsync() {
        Order order = orderService.createOrderWithEvent(true);
        return new ResultModel(order);
    }

    /**
     * 创建订单-事件发布-事件监听（泛型事件）
     *
     * @param
     * @return com.event.bootspringevent.util.ResultModel
     * @author CQ
     * @date 2020/2/21 15:56
     */
    @PostMapping("/createOrderWithGenericEvent")
    public ResultModel createOrderWithGenericEvent() {
        Order order = orderService.createOrderWithGenericEvent(true);
        return new ResultModel(order);
    }
}

