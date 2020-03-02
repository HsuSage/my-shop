package com.xu.my.shop.service.Impl;

import com.xu.my.shop.commons.context.SpringContext;
import com.xu.my.shop.dao.UserDao;
import com.xu.my.shop.entity.User;
import com.xu.my.shop.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = SpringContext.getBean("userDao");

    @Override
    public User login(String email, String password) {
        return userDao.getUser(email, password);
    }
}
