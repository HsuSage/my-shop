package com.xu.my.shop.dao;

import com.xu.my.shop.entity.User;

public interface UserDao {
    public User getUser(String email, String password);
}
