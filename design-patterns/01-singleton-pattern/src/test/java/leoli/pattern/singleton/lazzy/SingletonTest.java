package leoli.pattern.singleton.lazzy;

import org.junit.Test;

/**
 * 单例(懒汉)模式测试
 */
public class SingletonTest {

    @Test
    public void getSingleton() {

        System.out.printf("Lazzy Mode -> ");
        Singleton.getSingleton().doSomething();

    }
}