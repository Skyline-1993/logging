# logging
## 1. 日志框架简介
(1) 日志框架分为日志门面框架与日志实现框架，日志门面框架是接口层，是我们可直接使用的，日志实现框架是具体实现，具体的日志配置与其相关。
(2) 常见的日志门面框架有：Commons Logging、SLF4j、jboss-logging
(3) 常见的日志实现框架有：Log4j、JUL（java.util.logging）、Log4j2、Logback，其中，log4j与log4j2没有版本关系。
(4) 推荐使用：SLF4j + Logback(springboot底层使用)
## 2. 使用
```java
public class LoggingController {

    private Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @GetMapping("/hi")
    public String he() {
        logger.info("abc");
        return "hello world";
    }
}
```
在我们使用过程中因为有其他框架使用了其他日志框架，为了能让其他框架也使用SLF4j + Logback，我们需要先排除其他框架的日志框架，然后引入中间替换包。
```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-core</artifactId>
    <exclusions>
        <exclusion>
            <groupId>commons-logging</groupId>
            <artifactId>commons-logging</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```
## 3. 配置
###3.1 简单配置
一些简单的配置，我们可以在springboot的主配置文件中进行配置，如：
```yaml
logging:
  # 日志输出的等级
  level:
    com.skyline.logging.controller: warn
    com.skyline.logging.service: error
  # 日志配置文件的路径
  config: classpath:logback-spring.xml
  # 日志文件存放的路径(只能指定路径，不能指定文件)，默认日志文件是spring.log
  path: /logs/
  # 1.不指定路径，只配置文件名，默认在当前项目下生成日志 2.可以指定路径+文件名，在指定的路径下生成日志
  file: /logs/all.log
  exception-conversion-word:
  pattern:
    # 在控制台输出的格式
    console: 
    file:
    level:
  register-shutdown-hook:
```
日志输出格式(pattern)：
* %d表示日期时间
* %thread表示线程名，
* %-5level：级别从左显示5个字符宽度
* %logger{50} 表示logger名字最长50个字符，否则按照句点分割。 
* %msg：日志消息，
* %n是换行符  
    eg: %d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} - %msg%n  
###3.2 自定义配置文件
Logback的默认配置文件名为：logback.xml。直接在类路径下放入logback.xml即可生效，因为logback框架会自动识别。
但spring官方推荐在类路径下放logback-spring.xml配置文件，该文件不会被logback框架识别，但是会被springb框架识别，故可以在logback-spring.xml文件中配置springboot中特有的高级配置。如：
```xml
<!-- name属性指定了该配置项在dev开发环境生效 -->
<springProfile name="dev">
    <!--可以指定某段配置只在某个环境下生效 -->
    <!-- configuration to be enabled when the "staging" profile is active -->
    <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} ----> [%thread] ---> %-5level %logger{50} - %msg%n</pattern>
</springProfile>
```

