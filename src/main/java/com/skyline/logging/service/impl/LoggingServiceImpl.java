package com.skyline.logging.service.impl;

import com.skyline.logging.entity.User;
import com.skyline.logging.service.LoggingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author zhangkepeng
 * @Email skyline_1993@163.com
 * @Date 2019/5/21
 */
@Service
public class LoggingServiceImpl implements LoggingService {

    private Logger logger = LoggerFactory.getLogger(LoggingServiceImpl.class);

    @Override
    public User getUser(int id) {
        User user = new User();
        user.setId(001);
        user.setAge(22);
        user.setUserName("skyline");
        user.setNickName("天涯");
        user.setMobile("188********");
        logger.trace("This is trace of the service layer;");
        logger.debug("This is debug of the service layer;");
        logger.info("This is info of the service layer;");
        logger.warn("This is warn of the service layer;");
        logger.error("This is error of the service layer;");
        return user;
    }
}
