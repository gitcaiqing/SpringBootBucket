package com.event.bootspringevent.Listener;

import com.event.bootspringevent.Exception.BusinessException;
import com.event.bootspringevent.entity.Order;
import com.event.bootspringevent.entity.User;
import com.event.bootspringevent.event.OrderCreateEvent;
import com.event.bootspringevent.event.OrderCreateEventAsync;
import com.event.bootspringevent.service.ShortMessageSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Description 基于注解事件监听
 * @Author CQ
 * @Date 2020/2/21 15:27
 **/
@Component
@Slf4j
public class OrderCreateSendShortMessageAnnotationListener {

    @Autowired
    private ShortMessageSendService shortMessageSendService;

    /**
     * 1.启动类添加@EnableAsync注解开启支持异步
     * 2.监听方法上添加@Async注解，异步触发事件监听
     *
     * @param orderCreateEvent
     * @return void
     * @author CQ
     */
    @Async
    @EventListener
    public void orderCreateEvent(OrderCreateEventAsync orderCreateEvent) {
        log.info("②②②注解驱动@EventListener监听订单创建②②②");
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

            user = null;
            shortMessageSendService.sendShortMessage(user);
        } catch (Exception e) {
            throw new BusinessException("订单创建发送短信失败：" + e.getMessage());
        }
    }
}
