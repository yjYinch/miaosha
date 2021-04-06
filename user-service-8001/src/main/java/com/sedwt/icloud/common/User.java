package com.sedwt.icloud.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : zhang yijun
 * @date : 2021/3/15 14:56
 * @description : 用户实体类
 */

@Setter
@Getter
@ToString
public class User {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
