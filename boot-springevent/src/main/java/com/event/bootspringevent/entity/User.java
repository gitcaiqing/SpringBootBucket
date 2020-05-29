package com.event.bootspringevent.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_user")
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "user_id", length = 32)
    private String userId;

    @Column(name = "name", length = 100)

    @Length(max = 100, message = "用户名最多100字")
    @NotBlank(message = "用户名不能为空")
    private String name;

    private Long age;

    @Column(name = "identity_card")
    private String identityCard;

    private Integer sex;

    @Column(name = "birth_date")

    private Date birthDate;

    private Date createTime;

    private String mobile;

    @Temporal(TemporalType.DATE)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Transient
    public String getInfo() {

        return name + ":" + age;
    }

}
