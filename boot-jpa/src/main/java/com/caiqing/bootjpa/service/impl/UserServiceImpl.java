package com.caiqing.bootjpa.service.impl;

import com.caiqing.bootjpa.dao.UserDao;
import com.caiqing.bootjpa.dao.UserEntityManagerDao;
import com.caiqing.bootjpa.entity.User;
import com.caiqing.bootjpa.service.UserService;
import com.caiqing.bootjpa.util.UUIDUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserEntityManagerDao userEntityManagerDao;

    @Override
    public User addUser(User u) {
        User user = new User();
        BeanUtils.copyProperties(u, user);
        user.setUserId(UUIDUtils.getUUID());
        //user.setName("TEST01");
        user.setIdentityCard("362526199211065339");
        user.setSex(0);
        user.setAge(18L);
        user.setBirthDate(new Date());
        user.setCreateTime(new Date());
        return userDao.saveAndFlush(user);
    }

    @Override
    public List<Map<String, Object>> listUserMap() {
        return userEntityManagerDao.listUserMap();
    }

    @Override
    public List<User> listUserBean() {
        return userEntityManagerDao.listUser();
    }

    @Override
    public List<String> listUserName() {
        return userEntityManagerDao.listUserName();
    }
}
