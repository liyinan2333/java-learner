package leoli.pattern.strategy;

import leoli.pattern.strategy.templete.strategy.ConcreteStrategy1;
import leoli.pattern.strategy.templete.strategy.Strategy;
import org.junit.Test;

/**
 * 策略模式测试
 *
 * @author leoli
 * @date 2020/8/12
 */
public class StrategyTest {

    @Test
    public void testStrategy() {

        // 声明一个具体的策略
        Strategy strategy = new ConcreteStrategy1();
        // 声明上下文对象
        Context context = new Context(strategy);
        // 执行封装后的方法
        context.doAnything();

    }

}
