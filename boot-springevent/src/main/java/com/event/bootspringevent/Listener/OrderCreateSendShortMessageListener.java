package com.event.bootspringevent.Listener;

import com.event.bootspringevent.Exception.BusinessException;
import com.event.bootspringevent.entity.Order;
import com.event.bootspringevent.entity.User;
import com.event.bootspringevent.event.OrderCreateEvent;
import com.event.bootspringevent.service.ShortMessageSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 订单创建发送短信监听器
 */
@Slf4j
@Component
public class OrderCreateSendShortMessageListener implements ApplicationListener<OrderCreateEvent> {

    @Autowired
    private ShortMessageSendService shortMessageSendService;

    @Override
    public void onApplicationEvent(OrderCreateEvent orderCreateEvent) {
        log.info("①①①实现ApplicationListener接口监听订单创建①①①");
        if (orderCreateEvent == null) {
            throw new BusinessException("订单创建发送短信事件监听异常");
        }
        try {
            Object resource = orderCreateEvent.getSource();
            log.info("订单创建发送短信发布事件resource:{}", resource);
            Order order = orderCreateEvent.getOrder();
            log.info("订单创建发送短信发布事件order:{}", order);

            User user = new User();
            user.setName(order.getUserName());
            user.setMobile(order.getMobile());

            //user = null;
            shortMessageSendService.sendShortMessage(user);
        } catch (Exception e) {
            throw new BusinessException("订单创建发送短信失败：" + e.getMessage());
        }
    }
}
