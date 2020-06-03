package leoli.pattern.abstractfactory.product;

/**
 * 抽象产品类A
 *
 * @author leoli
 * @date 2020/6/3
 */
public abstract class AbstractProductA {

    // 每个产品有共有的方法
    public void shareMethod() {
        System.out.println("产品A -> 公共方法......");
    }

    // 每个产品相同方法，不同实现
    public abstract void doSomething();

}
