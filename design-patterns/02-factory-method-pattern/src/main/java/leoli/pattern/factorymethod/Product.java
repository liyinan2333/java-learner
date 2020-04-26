package leoli.pattern.factorymethod;

/**
 * 抽象产品类
 *
 * @author leoli
 * @date 2020/4/26
 */
public abstract class Product {

    // 产品类的公共方法
    public void method1() {
        System.out.println("I'm public method!");
    }

    // 抽象方法
    public abstract void method2();

}
