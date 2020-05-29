package com.caiqing.bootjpa.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tb_account")
@Data
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "account_id", length = 32)
    private String accountId;

    @Column(name = "user_id", length = 32)
    private String userId;

    @Column(name = "money")
    private Long money;

}
