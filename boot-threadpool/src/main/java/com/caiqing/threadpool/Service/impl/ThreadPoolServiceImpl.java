package com.caiqing.threadpool.Service.impl;

import com.caiqing.threadpool.Service.ThreadPoolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import javax.ejb.EJBs;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2019/12/3 16:46
 **/
@Service
@Slf4j
public class ThreadPoolServiceImpl implements ThreadPoolService {

    /**
     * 异步
     *
     * @param
     * @return void
     * @author CQ
     * @date 2019/12/3 16:47
     */
    @Override
    @Async
    public void executeAsync(Integer num) {
        log.info("executeAsync {} 开始执行 ->>>", num);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        log.info("executeAsync {} 执行结束 ->>>", num);
    }

    @Override
    public void executeSync(Integer num) {
        log.info("executeSync {} 开始执行 ->>>", num);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("executeSync {} 执行结束 ->>>", num);
    }
}
