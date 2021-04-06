package com.sedwt.icloud.service;

import com.sedwt.icloud.common.Result;
import com.sedwt.icloud.common.User;

import java.util.List;

/**
 * @author : zhang yijun
 * @date : 2021/3/15 14:48
 * @description : TODO
 */
public interface UserService {

    /**
     * 用户注册
     * @param username 用户名
     * @param password 密码
     * @return
     */
    Result signUp(String username, String password);

    /**
     * 用户登陆
     * @param username 用户名
     * @param password 密码
     * @return
     */
    Result login(String username, String password);

    /**
     * 查询用户
     * @param user
     * @return
     */
    List<User> getUser(User user);
}
