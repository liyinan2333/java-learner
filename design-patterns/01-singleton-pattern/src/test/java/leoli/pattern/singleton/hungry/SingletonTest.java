package leoli.pattern.singleton.hungry;

import org.junit.Test;

/**
 * 单例(饿汉)模式测试
 */
public class SingletonTest {

    @Test
    public void getSingleton() {

        System.out.printf("Hungry Mode -> ");
        Singleton.getSingleton().doSomething();

    }
}