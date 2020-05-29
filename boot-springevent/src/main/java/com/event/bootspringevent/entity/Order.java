package com.event.bootspringevent.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tb_order")
@Data
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "order_id", length = 32)
    private String orderId;

    @Column(name = "order_no", length = 32)
    private String orderNo;

    @Column(name = "account")
    private Long account;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "email")
    private String email;

}
