package com.caiqing.bootjpa.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_account_operate")
@Data
public class AccountOperate {


    @Id
    @GeneratedValue
    private Long id;

    /**
     * 账户操作uuid
     */
    private String operateId;

    /**
     * 账户uuid',
     */
    private String accountId;

    /**
     * 账户操作类型 0充值1消费扣除
     */
    private Integer operateType;

    /**
     * 操作金额
     */
    private Long money;

    /**
     * 操作人id
     */
    private String operateUserId;

    /**
     * 操作人名称
     */
    private String operateUserName;
}
