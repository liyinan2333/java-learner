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
