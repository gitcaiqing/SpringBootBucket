package com.caiqing.bootjpa.dao;

import com.caiqing.bootjpa.entity.User;
import org.hibernate.Hibernate;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

@Repository
public class UserEntityManagerDao {

    @Autowired
    //@PersistenceContext
    private EntityManager entityManager;

    //@Autowired
    private EntityManagerFactory entityManagerFactory;

    public List<Map<String,Object>> listUserMap(){
        String sql = "SELECT U.* FROM tb_user U";
        try {
            EntityManager em = entityManagerFactory.createEntityManager();
            return entityManager.createNativeQuery(sql)
                    .unwrap(org.hibernate.Query.class)
                    .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //EntityManagerFactoryUtils.closeEntityManager(em);
        }
        return null;
    }

    public List<Map<String,Object>> getUserMap(){
        String sql =  "select u.* from tb_user u";
        Query query = entityManager.createNativeQuery(sql);
        return query.getResultList();
    }

    public List<Map<String, Object>> joinUserMap(){
        String sql = "select u.*, a.money from tb_user u " +
                " left join tb_account a on a.user_id = u.id";
        org.hibernate.Query query = entityManager.createNativeQuery(sql)
                .unwrap(org.hibernate.Query.class)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    public List<User> listUser(){
//        String sql = "SELECT U.* FROM tb_user U";
//        return entityManager.createNativeQuery(sql)
//                .unwrap(org.hibernate.Query.class)
//                .setResultTransformer(Transformers.aliasToBean(User.class)).list();

        String sql = "SELECT U.* FROM tb_user U";
        return entityManager.createNativeQuery(sql, User.class).getResultList();

    }

    public List<String> listUserName(){
        String sql = "SELECT U.name FROM tb_user U";
        return entityManager.createNativeQuery(sql).getResultList();

    }
}
