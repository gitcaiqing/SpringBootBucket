package com.event.bootspringevent.service.impl;

import com.event.bootspringevent.Exception.BusinessException;
import com.event.bootspringevent.dao.OrderDao;
import com.event.bootspringevent.entity.Order;
import com.event.bootspringevent.entity.User;
import com.event.bootspringevent.event.OrderCreateEvent;
import com.event.bootspringevent.event.OrderCreateEventAsync;
import com.event.bootspringevent.event.OrderCreateGenericEvent;
import com.event.bootspringevent.service.OrderService;
import com.event.bootspringevent.util.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ShortMessageSendServiceImpl shortMessageSendService;

    @Autowired
    private ApplicationEventPublisher publisher;

    /**
     * 下单
     */
    @Transactional
    @Override
    public Order createOrder() {

        User user = new User();
        user.setUserId(UUIDUtils.getUUID());
        user.setName("CQ-01");
        user.setMobile("18779681526");

        //创建订单
        Order order = new Order();
        order.setOrderId(UUIDUtils.getUUID());
        order.setOrderNo("20200210ORDER001");
        order.setAccount(10000L);
        order.setUserId(user.getUserId());
        order.setMobile(user.getMobile());

        try {
            //保存订单
            orderDao.save(order);
            //给下单人发送短信

            // 模拟异常情况
            // user = null;
            shortMessageSendService.sendShortMessage(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("下单异常");
        }

        return order;
    }

    /**
     * 下单
     */
    @Transactional
    @Override
    public Order createOrderWithEvent(Boolean isSync) {
        User user = new User();
        Order order = new Order();
        buildData(user, order);
        try {
            //保存订单
            orderDao.save(order);
            //通过自定义订单创建事件 给下单人发送短信
            this.orderCreateSendShortMessage(isSync, order);
        } catch (Exception e) {
            //e.printStackTrace();
            throw new BusinessException("下单异常");
        }
        return order;
    }

    /**
     * 下单（走泛型事件）
     */
    @Transactional
    @Override
    public Order createOrderWithGenericEvent(Boolean isSync) {
        User user = new User();
        Order order = new Order();
        buildData(user, order);
        try {
            //保存订单
            orderDao.save(order);
            //泛型事件
            publisher.publishEvent(new OrderCreateGenericEvent(order, 0));
        } catch (Exception e) {
            //e.printStackTrace();
            throw new BusinessException("下单异常");
        }
        return order;
    }

    @Override
    public void createWaitSendGoods(Order order) {
        // TODO
        log.info("***************{}生成待发货记录", order.getOrderNo());
    }

    private void orderCreateSendShortMessage(Boolean isAsync, Order order) {
        if (isAsync) {
            //异步
            publisher.publishEvent(new OrderCreateEventAsync(this, order));
        } else {
            //同步
            publisher.publishEvent(new OrderCreateEvent(this, order));
        }
    }

    private void buildData(User user, Order order) {
        user.setUserId(UUIDUtils.getUUID());
        user.setName("CQ-02");
        user.setMobile("18779681526");

        order.setOrderId(UUIDUtils.getUUID());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
        order.setOrderNo(sdf.format(new Date()));
        order.setAccount(10000L);
        order.setUserName(user.getName());
        order.setUserId(user.getUserId());
        order.setMobile(user.getMobile());
    }
}
