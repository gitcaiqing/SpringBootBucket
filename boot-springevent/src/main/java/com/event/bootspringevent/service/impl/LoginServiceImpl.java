package com.event.bootspringevent.service.impl;

import com.event.bootspringevent.Exception.BusinessException;
import com.event.bootspringevent.entity.Order;
import com.event.bootspringevent.entity.User;
import com.event.bootspringevent.event.GenericEvent;
import com.event.bootspringevent.event.GenericEventResolvableType;
import com.event.bootspringevent.event.LoginSuccessGenericEvent;
import com.event.bootspringevent.event.OrderCreateGenericEvent;
import com.event.bootspringevent.service.LoginService;
import com.event.bootspringevent.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/2/21 17:17
 **/
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public User loginSuccessWithGenericEvent(Boolean isAsync) {
        User user = new User();
        user.setUserId(UUIDUtils.getUUID());
        user.setName("CQ-02");
        user.setMobile("18779681526");

        try {
            //泛型事件
            //publisher.publishEvent(new LoginSuccessGenericEvent(user, 1));

            //publisher.publishEvent(new GenericEvent<>(user, 1));

            publisher.publishEvent(new GenericEventResolvableType<>(user, 1));
        } catch (Exception e) {
            //e.printStackTrace();
            throw new BusinessException("登陆通知异常");
        }
        return user;
    }
}
