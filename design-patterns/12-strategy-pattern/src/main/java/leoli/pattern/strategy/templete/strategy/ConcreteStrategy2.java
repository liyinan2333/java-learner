package leoli.pattern.strategy.templete.strategy;

/**
 * 具体策略角色
 *
 * @author leoli
 * @date 2020/8/12
 */
public class ConcreteStrategy2 extends Strategy {

    @Override
    public void doSomething() {
        System.out.println("具体策略2的运算法则");
    }
}
