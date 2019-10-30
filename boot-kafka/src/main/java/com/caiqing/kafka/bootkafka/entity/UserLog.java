package com.caiqing.kafka.bootkafka.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author CQ
 * @Date 2019/10/30 14:14
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLog implements Serializable {

    private String userName;

    private String userId;

    private String state;
}
