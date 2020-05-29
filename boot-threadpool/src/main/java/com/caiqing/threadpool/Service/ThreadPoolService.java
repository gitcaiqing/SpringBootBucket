package com.caiqing.threadpool.Service;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2019/12/3 16:46
 **/
public interface ThreadPoolService {

    /**
     * 异步
     *
     * @param
     * @return void
     * @author CQ
     * @date 2019/12/3 16:47
     */
    void executeAsync(Integer num);

    void executeSync(Integer num);
}
