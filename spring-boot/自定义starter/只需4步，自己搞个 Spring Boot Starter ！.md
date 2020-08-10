### 只需4步，自己搞个 Spring Boot Starter ！
搜云库技术团队
#### 引言
只要你用Springboot，一定会用到各种spring-boot-starter。其实写一个spring-boot-starter，仅需4步。下面我们就写一个starter，它将实现，在日志中打印方法执行时间。
#### 第一步 创建maven项目
在使用spring-boot-starter，会发现，有的项目名称是 XX-spring-boot-starter，有的是spring-boot-starter-XX，这个项目的名称有什么讲究呢？从springboot官方文档摘录如下：

    Do not start your module names with spring-boot, even if you use a different Maven groupId. We may offer official support for the thing you auto-configure in the future. As a rule of thumb, you should name a combined module after the starter.

从这段话可以看出spring-boot-starter命名的潜规则。
#### 命名潜规则

    spring-boot-starter-XX是springboot官方的starter
    XX-spring-boot-starter是第三方扩展的starter

#### 第一步：项目配置
打印方法执行时间的功能，需要用到aop，咱们的项目就叫做aspectlog-spring-boot-starter吧。  
项目的pom文件如下：
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>leoli.springframework.boot</groupId>
    <artifactId>aspectlog-spring-boot-starter</artifactId>
    <version>1.0-SNAPSHOT</version>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.3.2.RELEASE</version>
    </parent>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-autoconfigure</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-aop</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>
    </dependencies>
</project>
```
关于spring-boot-configuration-processor的说明，引自springBoot官方文档：

    Spring Boot uses an annotation processor to collect the conditions on auto-configurations in a metadata file ( META-INF/spring-autoconfigure-metadata.properties ). If that file is present, it is used to eagerly filter auto-configurations that do not match, which will improve startup time. It is recommended to add the following dependency in a module that contains auto-configurations:

简单说就是 写starter时，在pom中配置spring-boot-autoconfigure-processor， 在编译时会自动收集配置类的条件，写到一个META-INF/spring-autoconfigure-metadata.properties中
#### 第二步：写自动配置逻辑
##### 各种condition

|类型|注解|说明|
|----|----|----|
Class Conditions类条件注解|@ConditionalOnClass|当前classpath下有指定类才加载
-|@ConditionalOnMissingClass|当前classpath下无指定类才加载
Bean ConditionsBean条件注解|@ConditionalOnBean|当期容器内有指定bean才加载
-|@ConditionalOnMissingBean|当期容器内无指定bean才加载
Property Conditions环境变量条件注解（含配置文件）|@ConditionalOnProperty|prefix 前缀name 名称havingValue 用于匹配配置项值matchIfMissing 没找指定配置项时的默认值
ResourceConditions 资源条件注解|@ConditionalOnResource|有指定资源才加载
Web Application Conditionsweb条件注解|@ConditionalOnWebApplication|是web才加载
-|@ConditionalOnNotWebApplication|不是web才加载
SpEL Expression Conditions|@ConditionalOnExpression|符合SpEL 表达式才加载
本次我们就选用@ConditionalOnProperty。即配置文件中有aspectLog.enable=true，才加载我们的配置类。下面开始写自动配置类
##### 定义AspectLog注解，该注解用于标注需要打印执行时间的方法。
```java
package leoli.springboot.autoconfiguration.aspectlog;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解，标注需要打印执行时间的方法
 *
 * @author leoli
 * @date 2020/8/10
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AspectLog {
}
```
##### 定义配置文件对应对应类
```java
package leoli.springboot.autoconfiguration.aspectlog;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置文件类
 *
 * @author leoli
 * @date 2020/8/10
 */
@ConfigurationProperties("aspectLog")
public class AspectLogProperties {

    private boolean enable;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
```
##### 定义自动配置类
```java
package leoli.springboot.autoconfiguration.aspectlog;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.PriorityOrdered;

/**
 * 自动配置类
 *
 * @author leoli
 * @date 2020/8/10
 */
@Aspect
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
@Configuration
@ConditionalOnProperty(prefix = "aspectLog", name = "enable", havingValue = "true", matchIfMissing = true)
public class AspectLogAutoConfiguration implements PriorityOrdered {

    protected static Logger LOGGER = LoggerFactory.getLogger(AspectLogAutoConfiguration.class);

    @Around("@annotation(leoli.springboot.autoconfiguration.aspectlog.AspectLog) ")
    public Object isOpen(ProceedingJoinPoint joinPoint) throws Throwable {
        //执行方法名称
        String taskName = joinPoint.getSignature().toString().substring(
                joinPoint.getSignature().toString().indexOf(" "),
                joinPoint.getSignature().toString().indexOf("("));
        taskName = taskName.trim();
        long time = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        LOGGER.info("method:{} run :{} ms", taskName, (System.currentTimeMillis() - time));
        return result;
    }

    @Override
    public int getOrder() {
        // bean装在顺序设置为最低，保证事务等切面先执行
        return Integer.MAX_VALUE;
    }
}
```
配置类简要说明：
@ConditionalOnProperty(prefix = "aspectLog", name = "enable",havingValue = "true", matchIfMissing = true)
当配置文件有aspectLog.enable=true时开启，如果配置文件没有设置aspectLog.enable也开启。
#### 第三步 META-INF/spring.factories
META-INF/spring.factories是spring的工厂机制，在这个文件中定义的类，都会被自动加载。多个配置使用逗号分割，换行用\
在resources/META-INF目录下新建spring.factories文件，内容如下
```
# Autoconfiguration自动装配
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
com.shanyuan.autoconfiguration.aspectlog.AspectLogAutoConfiguration
```
如果有兴趣可以查看这2篇blog：
* @Enable驱动原理(设置连接)
* @EnableAutoConfiguration处理逻辑(设置连接)
#### 第四步 打包测试
这是我们最终的目录结构:
略...
在IDEA中，进行mvn intall
打包完成后，在其他项目中的pom中引入进行测试