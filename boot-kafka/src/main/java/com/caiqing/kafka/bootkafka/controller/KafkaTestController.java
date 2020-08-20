package com.caiqing.kafka.bootkafka.controller;

import com.caiqing.kafka.bootkafka.producer.UserLogProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2019/10/30 14:22
 **/
@RestController
@RequestMapping("/kafka/test")
public class KafkaTestController {

    @Autowired
    private UserLogProducer userLogProducer;

    /**
     * 10.67.8.78:2002/kafka-app/kafka/test/userLog
     *
     * @param
     * @return java.lang.String
     * @author CQ
     * @date 2019/10/30 14:47
     */
    @GetMapping("/userLog")
    public String kafkaTest() {
        userLogProducer.sendLog("001");
        return "发送数据成功";
    }

    @GetMapping("/userLog2")
    public String kafkaTest2() {
        userLogProducer.sendLog2("002");
        return "发送数据成功";
    }
}
