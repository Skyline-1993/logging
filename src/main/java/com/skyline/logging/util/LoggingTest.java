package com.skyline.logging.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhangkepeng
 * @Email skyline_1993@163.com
 * @Date 2019/5/9
 */
public class LoggingTest {

    public static final Logger logger = LoggerFactory.getLogger(LoggingTest.class);

    public static void main(String[] args) {
        // 这些方法中第一个参数中可以加上多个{}，依次使用第二个、第三个··· 参数填充
        logger.trace("{}级别日志","trace");      // 输出：trace级别日志
        logger.debug("{}级别日志{}","debug");    // 如果第二个{}没有对应的参数填充，那么会直接输出{}
        logger.info("{}级别日志","info","aaa");  // 如果第三个参数没有对应的{}去填充，那么这个参数不起作用
        logger.warn("{}级别日志","warn");
        logger.error("{}级别日志","error");
    }

}
