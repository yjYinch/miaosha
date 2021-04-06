package com.sedwt.icloud.controller;

import com.sedwt.icloud.common.Result;
import com.sedwt.icloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhang yijun
 * @date : 2021/3/15 14:17
 * @description : TODO
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @GetMapping("/signup")
    public Result signUp(@RequestParam String username, @RequestParam String password){
        //TODO 参数校验
        return userService.signUp(username, password);
    }

    /**
     * 用户登陆
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @GetMapping("/login")
    public Result login(@RequestParam String username, @RequestParam String password){
        // TODO 参数校验
        return userService.login(username, password);
    }
}
