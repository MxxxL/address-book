package com.kaiyu.service;

import com.kaiyu.dao.IUserDao;
import com.kaiyu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mxxxl
 * @date 2020/12/18
 */
@Service
public class UserServiceImpl implements IUserService{

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
