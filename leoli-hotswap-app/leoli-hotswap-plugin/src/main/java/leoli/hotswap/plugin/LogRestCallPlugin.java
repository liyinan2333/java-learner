package leoli.hotswap.plugin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;

/**
 * @author leoli
 * @date 2021/06/05
 */
public class LogRestCallPlugin implements MethodBeforeAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogRestCallPlugin.class);

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        RequestMapping methodAnno = method.getAnnotation(RequestMapping.class);
        String methodUrl = (methodAnno != null && methodAnno.value() != null && methodAnno.value().length > 0) ? methodAnno.value()[0] : "";
        RequestMapping classAnno = method.getDeclaringClass().getAnnotation(RequestMapping.class);
        Assert.notNull(classAnno, "Cannot find annotation @RequestMapping.");
        String classUrl = (classAnno != null && classAnno.value() != null && classAnno.value().length > 0) ? classAnno.value()[0] : "";
        String url = (classUrl + "/" + methodUrl).replace("//", "/").replace("///", "/");
        LOGGER.info("Web call \"{}\" ", url);
    }

}
