package com.skyline.logging.service;

import com.skyline.logging.entity.User;

import java.util.Map;

/**
 * @author zhangkepeng
 * @Email skyline_1993@163.com
 * @Date 2019/5/21
 */
public interface LoggingService {

    /**
     * 根据用户id获取用户信息
     * @param id 用户id
     * @return 用户对象
     */
    User getUser(int id);
}
