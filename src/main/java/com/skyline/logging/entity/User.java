package com.skyline.logging.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhangkepeng
 * @Email skyline_1993@163.com
 * @Date 2019/5/21
 */
@Getter
@Setter
public class User {

    /**
     * 用户id
     */
    private int id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 密码
     */
    private String password;
    /**
     * 密码
     */
    private int age;

}
