package com.caiqing.threadpool.controller;

import com.caiqing.threadpool.Service.ThreadPoolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Description 线程池测试Controller
 * @Author CQ
 * @Date 2019/12/3 16:38
 **/
@RestController
@RequestMapping("/threadPool")
@Slf4j
public class ThreadController {

    @Autowired
    private ThreadPoolService threadPoolService;

    /**
     * 异步
     * @param
     * @return java.lang.Object
     * @author CQ
     * @date 2019/12/3 16:45
     */
    @GetMapping("/asyncTest")
    public Object asyncTest(){
        for (int i = 0; i < 100; i++){
            threadPoolService.executeAsync(i);
        }
        return "success";
    }

    /**
     * 异步
     * @param
     * @return java.lang.Object
     * @author CQ
     * @date 2019/12/3 16:45
     */
    @GetMapping("/syncTest")
    public Object syncTest(){
        for (int i = 0; i < 100; i++){
            threadPoolService.executeSync(i);
        }
        return "success";
    }
}
