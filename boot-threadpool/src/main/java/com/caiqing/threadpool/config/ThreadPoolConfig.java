package com.caiqing.threadpool.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2019/12/3 16:28
 **/
@Configuration
@EnableAsync
@Slf4j
public class ThreadPoolConfig {

    /**
     * corePoolSize：核心线程数
     * 核心线程会一直存活，及时没有任务需要执行
     * 当线程数小于核心线程数时，即使有线程空闲，线程池也会优先创建新线程处理
     * 设置allowCoreThreadTimeout=true（默认false）时，核心线程会超时关闭
     * queueCapacity：任务队列容量（阻塞队列）
     * 当核心线程数达到最大时，新任务会放在队列中排队等待执行
     * maxPoolSize：最大线程数
     * 当线程数>=corePoolSize，且任务队列已满时。线程池会创建新线程来处理任务
     * 当线程数=maxPoolSize，且任务队列已满时，线程池会拒绝处理任务而抛出异常
     * keepAliveTime：线程空闲时间
     * 当线程空闲时间达到keepAliveTime时，线程会退出，直到线程数量=corePoolSize
     * 如果allowCoreThreadTimeout=true，则会直到线程数量=0
     * allowCoreThreadTimeout：允许核心线程超时
     * rejectedExecutionHandler：任务拒绝处理器
     * 两种情况会拒绝处理任务：
     * 当线程数已经达到maxPoolSize，切队列已满，会拒绝新任务
     * 当线程池被调用shutdown()后，会等待线程池里的任务执行完毕，再shutdown。如果在调用shutdown()和线程池真正shutdown之间提交任务，会拒绝新任务
     * 线程池会调用rejectedExecutionHandler来处理这个任务。如果没有设置默认是AbortPolicy，会抛出异常
     * ThreadPoolExecutor类有几个内部实现类来处理这类情况：
     * AbortPolicy 丢弃任务，抛运行时异常
     * CallerRunsPolicy 执行任务
     * DiscardPolicy 忽视，什么都不会发生
     * DiscardOldestPolicy 从队列中踢出最先进入队列（最后一个执行）的任务
     * 实现RejectedExecutionHandler接口，可自定义处理器
     * <p>
     * 默认值
     * corePoolSize=1
     * queueCapacity=Integer.MAX_VALUE
     * maxPoolSize=Integer.MAX_VALUE
     * keepAliveTime=60s
     * allowCoreThreadTimeout=false
     * rejectedExecutionHandler=AbortPolicy()
     *
     * @param
     * @return org.springframework.core.task.TaskExecutor
     * @author CQ
     * @date 2019/12/3 18:28
     */
    @Bean
    public TaskExecutor taskExecutor() {
        log.info("executor start ->>>");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 设置核心线程数
        executor.setCorePoolSize(80);
        // 设置最大线程数
        executor.setMaxPoolSize(92);
        // 设置队列容量
        executor.setQueueCapacity(80);
        // 设置线程活跃时间（秒）
        executor.setKeepAliveSeconds(60);
        // 不允许核心线程超时
        executor.setAllowCoreThreadTimeOut(false);
        // 配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("thread-async-");
        // 设置拒绝策略rejection-policy：当pool已经达到max size的时候，
        // 如何处理新任务 CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 执行初始化
        executor.initialize();
        log.info("executor init ->>>:{}", executor);
        return executor;
    }
}
