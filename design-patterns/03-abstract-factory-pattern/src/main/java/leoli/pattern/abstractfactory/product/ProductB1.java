package leoli.pattern.abstractfactory.product;

/**
 * 具体产品B1
 *
 * @author leoli
 * @date 2020/6/3
 */
public class ProductB1 extends AbstractProductB {
    @Override
    public void doSomething() {
        System.out.println("产品B1 -> 实现方法");
    }
}
