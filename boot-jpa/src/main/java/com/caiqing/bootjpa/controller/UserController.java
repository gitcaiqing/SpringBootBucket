package com.caiqing.bootjpa.controller;

import com.caiqing.bootjpa.entity.User;
import com.caiqing.bootjpa.service.UserService;
import com.caiqing.bootjpa.util.ResultModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    public ResultModel<User> addUser(@Valid @RequestBody User user, BindingResult errors){
        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(
                    error -> log.error(error.toString())
            );
            return new ResultModel<>(201,errors.getAllErrors().get(0).getDefaultMessage());
        }
        return new ResultModel<>(userService.addUser(user));
    }

    @RequestMapping("/listUserMap")
    public ResultModel<List<Map<String, Object>>> listUserMap(){
        return new ResultModel<List<Map<String, Object>>>(userService.listUserMap());
    }
    @RequestMapping("/listUserBean")
    public ResultModel<List<User>> listUserBean(){
        return new ResultModel<List<User>>(userService.listUserBean());
    }

    @RequestMapping("/listUserName")
    public ResultModel<List<String>> listUserName(){
        ResultModel<List<String>> resultModel = new ResultModel<>();
        List<String> usernameList = userService.listUserName();
        System.out.println(usernameList);
        resultModel.setData(usernameList);
        return resultModel;
    }

}
