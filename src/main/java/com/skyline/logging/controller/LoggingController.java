package com.skyline.logging.controller;

import com.skyline.logging.entity.User;
import com.skyline.logging.service.LoggingService;
import com.skyline.logging.util.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangkepeng
 * @email skyline_1993@163.com
 * @data 2019/6/12
 */
@RestController
public class LoggingController {

    @Autowired
    private LoggingService loggingService;

    /**
     * 日志记录器
     */
    private Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @RequestMapping("/getUser")
    public R getUser(Integer id) {

        logger.trace("This is trace of the controller layer;");
        logger.debug("This is debug of the controller layer;");
        logger.info("This is info of the controller layer;");
        logger.warn("This is warn of the controller layer;");
        logger.error("This is error of the controller layer;");

        // {}会用后面的参数替换
        User user = loggingService.getUser(id);
        logger.debug("获取用户信息：[{}]", user.getUserName());

        return R.ok().put("data", user);
    }
}
