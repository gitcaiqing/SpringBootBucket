package com.event.bootspringevent.controller;

import com.event.bootspringevent.entity.Order;
import com.event.bootspringevent.entity.User;
import com.event.bootspringevent.service.LoginService;
import com.event.bootspringevent.util.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event/login")
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 成功登陆-事件发布-事件监听（泛型事件）
     * @param
     * @return com.event.bootspringevent.util.ResultModel
     * @author CQ
     * @date 2020/2/21 15:56
     */
    @PostMapping("/loginSuccessWithGenericEvent")
    public ResultModel loginSuccessWithGenericEvent(){
        User user = loginService.loginSuccessWithGenericEvent(true);
        return new ResultModel(user);
    }
}
