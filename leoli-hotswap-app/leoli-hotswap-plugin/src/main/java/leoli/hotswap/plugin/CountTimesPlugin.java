package leoli.hotswap.plugin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author leoli
 * @date 2021/06/05
 */
@Component
public class CountTimesPlugin implements MethodBeforeAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountTimesPlugin.class);
    private Map<String, AtomicInteger> countMap = new HashMap<>();

    private int count;

    protected void count(Method method) {
        if(countMap.containsKey(method.getDeclaringClass().getName() + "." + method.getName()) +) {
            count++;
        }
    }

    @Override
    public void before(Method method, Object[] objects, Object o) {

        count(method);
        LOGGER.info("The method {}() invoked times {}.", method.getName(), count);

    }
}
