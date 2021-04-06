package com.sedwt.icloud.mapper;

import com.sedwt.icloud.common.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : zhang yijun
 * @date : 2021/3/15 14:50
 * @description : TODO
 */

@Mapper
public interface UserMapper {
    /**
     * 新增用户
     * @param username 用户名
     * @param password 密码
     * @return
     * //@Insert("INSERT INTO `user`(username, password) VALUES (#{username}, #{password})")
     */
    int insert(String username, String password);

    /**
     * 根据条件查询用户
     * @param user
     * @return
     */
    List<User> getUserByCondition(User user);
}
