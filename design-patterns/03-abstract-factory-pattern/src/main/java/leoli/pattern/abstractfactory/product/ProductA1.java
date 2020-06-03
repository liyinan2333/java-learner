package leoli.pattern.abstractfactory.product;

/**
 * 具体产品A1
 *
 * @author leoli
 * @date 2020/6/3
 */
public class ProductA1 extends AbstractProductA {
    @Override
    public void doSomething() {
        System.out.println("产品A1 -> 实现方法");
    }
}
