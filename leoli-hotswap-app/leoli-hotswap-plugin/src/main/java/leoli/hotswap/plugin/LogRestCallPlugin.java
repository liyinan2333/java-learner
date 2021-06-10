package leoli.hotswap.plugin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author leoli
 * @date 2021/06/05
 */
public class LogRestCallPlugin implements MethodBeforeAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogRestCallPlugin.class);
    private Map<String, AtomicInteger> countMap = new HashMap<>();

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        RequestMapping methodAnno = method.getAnnotation(RequestMapping.class);
        String[] methodUrl = methodAnno.value();
        RequestMapping classAnno = method.getDeclaringClass().getAnnotation(RequestMapping.class);
        Assert.notNull(classAnno, "Cannot find annotation @RequestMapping.");
        String[] classUrl = classAnno.value();
        String url = (methodUrl[0] + "/" + classUrl[0]).replace("//", "/").replace("///", "/");
        LOGGER.info("Web call \"{}\" ", url);
    }
}
