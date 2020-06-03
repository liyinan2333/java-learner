package leoli.pattern.templatemethod;

/**
 * 抽象模板类
 *
 * @author leoli
 * @date 2020/6/3
 */
public abstract class AbstractClass {

    // 基本方法
    protected abstract void doSomething();

    // 基本方法
    protected abstract void doAnything();

    /**
     * 模板方法, 调用基本方法，完成相关的逻辑
      */
    public void templateMethod() {
        this.doAnything();
        this.doSomething();
    }

}
