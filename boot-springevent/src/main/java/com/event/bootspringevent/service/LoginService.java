package com.event.bootspringevent.service;

import com.event.bootspringevent.entity.Order;
import com.event.bootspringevent.entity.User;

public interface LoginService {

    //登陆成功后通过事件驱动进行业务解耦
    User loginSuccessWithGenericEvent(Boolean isAsync);
}
