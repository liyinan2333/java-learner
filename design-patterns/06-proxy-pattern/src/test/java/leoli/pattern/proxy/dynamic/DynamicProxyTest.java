package leoli.pattern.proxy.dynamic;

import org.junit.Test;

/**
 * 动态代理测试类
 */
public class DynamicProxyTest {

    @Test
    public void dynamicProxyTest1() {
        // 定义一个主题
        Subject subject = new RealSubject();

        Subject proxy = DynamicProxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), new MyInvocationHandler(new RealSubject()));
        // 代理的行为
        proxy.doSomething("想唱歌~");
    }

    @Test
    public void dynamicProxyTest2() {
        // 定义一个主题
        Subject subject = new RealSubject();

        Subject proxy = SubjectDynamicProxy.newProxyInstance(subject);
        // 代理的行为
        proxy.doSomething("想唱歌~");
    }

}
