package com.skyline.logging.controller;

import com.skyline.logging.entity.User;
import com.skyline.logging.util.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangkepeng
 * @Email skyline_1993@163.com
 * @Date 2019/6/12
 */
@RestController
public class LoggingContorller {

    private static final Logger logger = LoggerFactory.getLogger(LoggingContorller.class);

    @RequestMapping("/hi")
    public R hi(@RequestBody User user){
        logger.debug("start");
        // {}会用后面的参数替换
        logger.info("尊敬的{}用户，非常感谢您注册我们的账户" ,user.getUserName());
        logger.debug("end");
        return R.ok();
    }
}
