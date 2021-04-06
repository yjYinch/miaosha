package com.sedwt.icloud.service.impl;

import com.sedwt.icloud.common.Result;
import com.sedwt.icloud.common.User;
import com.sedwt.icloud.mapper.UserMapper;
import com.sedwt.icloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : zhang yijun
 * @date : 2021/3/15 14:48
 * @description : TODO
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result signUp(String username, String password) {
        int total = userMapper.insert(username, password);
        if (total != 1){
            return Result.fail("新增用户失败");
        }
        return Result.success();
    }

    /**
     * 用户登陆
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @Override
    public Result login(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        List<User> users = getUser(user);
        if (users.size() != 1){
            return Result.fail("登陆失败");
        }
        return Result.success("登陆成功");
    }

    /**
     * 查询用户
     *
     * @param user
     * @return
     */
    @Override
    public List<User> getUser(User user) {
        List<User> users = userMapper.getUserByCondition(user);
        return users;
    }
}
