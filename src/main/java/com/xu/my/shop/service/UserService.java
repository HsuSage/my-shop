package com.xu.my.shop.service;

import com.xu.my.shop.entity.User;

public interface UserService {
    /**
     * 登录
     * @param email
     * @param password
     * @return com.xu.my.shop.entity.User
     * @author Xu
     * @date 2020/2/21 22:34
     */
    public User login(String email, String password);
}
