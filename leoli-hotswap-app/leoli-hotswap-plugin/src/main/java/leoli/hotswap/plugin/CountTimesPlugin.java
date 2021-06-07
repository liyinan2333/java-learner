package leoli.hotswap.plugin;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author leoli
 * @date 2021/06/05
 */
@Aspect
@Component
public class CountTimesPlugin {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountTimesPlugin.class);
    private Map<String, AtomicInteger> countMap = new HashMap<>();

    protected int count(String fullMethodName) {
        if (countMap.containsKey(fullMethodName)) {
            AtomicInteger atomicInteger = countMap.get(fullMethodName);
            return atomicInteger.incrementAndGet();
        } else {
            AtomicInteger atomicInteger = new AtomicInteger();
            countMap.put(fullMethodName, atomicInteger);
            return atomicInteger.incrementAndGet();
        }
    }

    @Before(value = "execution(* leoli.hotswap..*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        String fullMethodName = joinPoint.getSignature().getClass().getName() + "#" + joinPoint.getSignature().toLongString();
        LOGGER.info("Method [{}] call {} times", fullMethodName, count(fullMethodName));
    }
}
