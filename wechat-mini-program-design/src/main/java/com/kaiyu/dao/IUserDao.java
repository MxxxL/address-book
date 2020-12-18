package com.kaiyu.dao;

import com.kaiyu.entity.User;
import org.springframework.stereotype.Repository;

/**
 * 用户的持久层接口
 * @author mxxxl
 * @date 2020/12/17
 */
@Repository
public interface IUserDao {

    /**
     * 用户登录(根据用户名密码查询用户)
     * @param username 用户名
     * @param password 密码
     * @return 查询到的用户
     */
    User selectUser(String username,String password);

    /**
     * 用户注册
     * @param user 待注册的用户
     * @return 注册结果
     */
    int saveUser(User user);
}
