package com.caiqing.bootjpa.service;

import com.caiqing.bootjpa.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface UserService {

    User addUser(User user);

    List<Map<String, Object>> listUserMap();

    List<User> listUserBean();

    List<String> listUserName();
}
