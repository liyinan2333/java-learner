package liyinan.proxy.jdk;

import liyinan.proxy.jdk.service.IService;
import liyinan.proxy.jdk.service.IUserService;
import liyinan.proxy.jdk.service.ServiceA;
import liyinan.proxy.jdk.service.ServiceB;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    @Test
    public void m1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 1. 获取接口对应的代理类
        Class<IService> proxyClass = (Class<IService>) Proxy.getProxyClass(IService.class.getClassLoader(), IService.class);
        // 2. 创建代理类的处理器
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("我是InvocationHandler，被调用的方法是：" + method.getName());
                return null;
            }
        };
        // 3. 创建代理实例
        IService proxyService = proxyClass.getConstructor(InvocationHandler.class).newInstance(invocationHandler);
        // 4. 调用代理的方法
        proxyService.m1();
        proxyService.m2();
        proxyService.m3();
    }

    @Test
    public void m2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 1. 创建代理类的处理器
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("我是InvocationHandler，被调用的方法是：" + method.getName());
                return null;
            }
        };
        // 2. 创建代理实例
        IService proxyService = (IService) Proxy.newProxyInstance(IService.class.getClassLoader(), new Class[]{IService.class}, invocationHandler);
        // 3. 调用代理的方法
        proxyService.m1();
        proxyService.m2();
        proxyService.m3();
    }

    @Test
    public void costTimeProxy() {
        IService serviceA = CostTimeInvocationHandler.createProxy(new ServiceA(), IService.class);
        IService serviceB = CostTimeInvocationHandler.createProxy(new ServiceB(), IService.class);
        serviceA.m1();
        serviceA.m2();
        serviceA.m3();

        serviceB.m1();
        serviceB.m2();
        serviceB.m3();
    }

    @Test
    public void userService() {
        IUserService userService = CostTimeInvocationHandler.createProxy(new UserService(), IUserService.class);
        userService.insert("路人甲Java");
        System.out.println(userService.getClass());
    }
}
