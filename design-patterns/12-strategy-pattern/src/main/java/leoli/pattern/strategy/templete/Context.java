package leoli.pattern.strategy.templete;

import leoli.pattern.strategy.templete.strategy.Strategy;

/**
 * 封装角色
 *
 * @author leoli
 * @date 2020/8/12
 */
public class Context {

    // 抽象策略
    private Strategy strategy = null;

    // 构造函数设置具体策略
    public Context(Strategy _strategy) {
        this.strategy = _strategy;
    }

    // 封装后的策略方法
    public void doAnything() {
        this.strategy.doSomething();
    }

}
