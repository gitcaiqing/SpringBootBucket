package com.event.bootspringevent.Listener;

import com.event.bootspringevent.Exception.BusinessException;
import com.event.bootspringevent.entity.Order;
import com.event.bootspringevent.entity.User;
import com.event.bootspringevent.event.GenericEvent;
import com.event.bootspringevent.event.OrderCreateEventAsync;
import com.event.bootspringevent.service.ShortMessageSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Condition;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Description 基于注解监听泛型事件GenericEvent具体实现
 * @Author CQ
 * @Date 2020/2/21 15:27
 **/
@Component
@Slf4j
public class SendShortMessageGenericListener {

    @Autowired
    private ShortMessageSendService shortMessageSendService;

   /**
    * 订单创建
    * 1.启动类添加@EnableAsync注解开启支持异步
    * 2.监听方法上添加@Async注解，异步触发事件监听
    * @param genericEvent
    * @return void
    * @author CQ
    */
    @Async
    @EventListener(condition = "#genericEvent.type == 0")
    public void orderCreateEventListener(GenericEvent<Order> genericEvent){
        log.info("③③③注解驱动@EventListener监听泛型事件GenericEvent<Order> genericEvent.type = 0 订单创建成功后短信通知③③③");
        if(genericEvent == null){
            throw new BusinessException("订单创建发送短信事件监听异常");
        }
        try {
            Order order = genericEvent.getData();
            log.info("订单创建发送短信发布事件order:{}", order);

            User user = new User();
            user.setName(order.getUserName());
            user.setMobile(order.getMobile());

            //user = null;
            shortMessageSendService.sendShortMessage(user);
        } catch (Exception e) {
            throw new BusinessException("订单创建发送短信失败："+e.getMessage());
        }
    }

    /**
     * 登陆成功
     * 1.启动类添加@EnableAsync注解开启支持异步
     * 2.监听方法上添加@Async注解，异步触发事件监听
     * @param genericEvent
     * @return void
     * @author CQ
     */
    @Async
    @EventListener(condition = "#genericEvent.type == 1")
    public void loginSuccessEventListener(GenericEvent<User> genericEvent){
        log.info("③③③注解驱动@EventListener监听泛型事件GenericEvent<User> genericEvent.type = 1 登陆成功后短信通知③③③");
        if(genericEvent == null){
            throw new BusinessException("订单创建发送短信事件监听异常");
        }
        try {
            User user = genericEvent.getData();
            log.info("登陆成功发送短信发布事件user:{}", user);

            //user = null;
            shortMessageSendService.sendShortMessage(user);
        } catch (Exception e) {
            throw new BusinessException("登陆成功发送短信失败："+e.getMessage());
        }
    }
}
