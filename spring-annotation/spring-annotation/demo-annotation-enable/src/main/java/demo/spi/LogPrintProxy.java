package demo.spi;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * (可进一步实现，若该类满足某些条件才打印，比如：包含@LogPrint注解)
 *
 * @author: liyinan2333
 * @date: 2022/06/08
 */
public class LogPrintProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("类名：" + obj.getClass() + "    方法名：" + method.getName() + "    执行耗时：" + (System.currentTimeMillis() - start));
        return result;
    }

}
