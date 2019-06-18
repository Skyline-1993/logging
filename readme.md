# logging
## 1. 日志简介
> 日志框架分为日志门面框架与日志实现框架，日志门面框架是接口层，
是我们可直接使用的，日志实现框架是具体实现，具体的日志配置与其相关。
> 常见的日志门面框架有：Commons Logging、SLF4j、jboss-logging
> 常见的日志实现框架有：Log4j、JUL（java.util.logging）、Log4j2、Logback，其中，log4j与log4j2没有版本关系。
> 推荐使用：SLF4j + Logback(springboot底层使用)
## 2. 使用
```java
public class LoggingController {

    public static final Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @GetMapping("/hi")
    public String he() {
        logger.info("abc");
        return "hello world";
    }
}
```
在我们使用过程中因为有其他框架使用了其他日志框架，为了能让其他框架也使用SLF4j + Logback，
我们需要先排除其他框架的日志框架，然后引入中间替换包。
## 3. 配置
Logback的配置文件名为：logback.xml。一些简单的配置，我们可以在springboot的主配置文件中进行配置，如：
```properties
logging.level.com.skyline.logging.util.LoggingTest=info
```
```java
logger.info("{}级别日志","info");
logger.warn("{}级别日志","warn");
```

