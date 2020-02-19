package com.event.bootspringevent.service.impl;

import com.event.bootspringevent.entity.Order;
import com.event.bootspringevent.entity.User;
import com.event.bootspringevent.service.ShortMessageSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
public class ShortMessageSendServiceImpl implements ShortMessageSendService {

    /**
     * 发送邮件
     */
    @Override
    public void sendShortMessage(User user) {
        log.info("用户：{} 下单成功并发短信，手机号：{}", user.getName(), user.getMobile());
    }


    /**
     * 监听
     */
    @EventListener
    public void sendMailListener(Order order){

    }

}
