package com.event.bootspringevent.event;

import com.event.bootspringevent.entity.User;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2020/2/21 16:29
 **/
public class LoginSuccessGenericEventResolvableType extends GenericEventResolvableType<User>{

    public LoginSuccessGenericEventResolvableType(User user, Integer type){
        super(user, type);
    }
}
