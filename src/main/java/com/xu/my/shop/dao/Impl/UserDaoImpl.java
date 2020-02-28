package com.xu.my.shop.dao.Impl;

import com.xu.my.shop.dao.UserDao;
import com.xu.my.shop.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDaoImpl implements UserDao {
    private static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public User getUser(String email, String password) {
        logger.debug("调用 getUser(), email:{} password:{}", email, password);

        User user = null;

        if ("admin@163.com".equals(email)) {
            if ("admin".equals(password)) {
                user =new User();
                user.setEmail("admin@163.com");
                user.setUsername("Xu");

                logger.info("成功获取\"{}\"的用户信息", user.getUsername());
            }
        } else {
            logger.warn("获取用户信息失败");
        }

        return user;
    }
}
