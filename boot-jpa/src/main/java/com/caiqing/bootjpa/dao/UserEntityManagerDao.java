package com.caiqing.bootjpa.dao;

import com.caiqing.bootjpa.entity.User;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserEntityManagerDao {

    @Autowired
    private EntityManager entityManager;

    public List<Map<String,Object>> listUserMap(){
        String sql = "SELECT U.* FROM tb_user U";
        try {
            return entityManager.createNativeQuery(sql)
                    .unwrap(org.hibernate.Query.class)
                    .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            EntityManagerFactoryUtils.closeEntityManager(entityManager);
        }
        return null;
    }

    public List<User> listUser(){
        String sql = "SELECT U.* FROM tb_user U";
        return entityManager.createNativeQuery(sql)
                .unwrap(org.hibernate.Query.class)
                .setResultTransformer(Transformers.aliasToBean(User.class)).list();

    }

    public List<String> listUserName(){
        String sql = "SELECT U.name FROM tb_user U";
        return entityManager.createNativeQuery(sql).getResultList();

    }
}
