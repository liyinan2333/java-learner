package demo.anno;

import demo.spi.LogPrintBeanPostProcessor;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author: liyinan2333
 * @date: 2022/06/08
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(LogPrintBeanPostProcessor.class)
public @interface EnableLogPrint {
}
