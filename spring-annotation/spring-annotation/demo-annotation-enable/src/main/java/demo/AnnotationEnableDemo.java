package demo;

import demo.anno.EnableLogPrint;
import demo.service.DemoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 需求：为每个方法打印类名、方法名、执行耗时
 * <p>
 * 实现方式: @EnableLogPrint注解
 * 也可通过@Conditional或@ConditionalOnProperties进一步扩展为其它开启方式，或导一个spring-boot-auto-configuration出来
 *
 * @author: liyinan2333
 * @date: 2022/06/08
 */
@EnableLogPrint
@ComponentScan
public class AnnotationEnableDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationEnableDemo.class);
        context.getBean(DemoService.class).doSomething();
    }

}
