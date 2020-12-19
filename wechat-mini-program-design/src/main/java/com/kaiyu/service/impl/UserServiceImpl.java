package com.kaiyu.service.impl;

import com.kaiyu.dao.IUserDao;
import com.kaiyu.entity.User;
import com.kaiyu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务层实现类
 * @author mxxxl
 * @date 2020/12/18
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDao userDao;

    @Override
    public User selectUser(String username, String password) {
        return userDao.selectUser(username, password);
    }

    @Override
    public int saveUser(User user) {
        return userDao.saveUser(user);
    }
}
