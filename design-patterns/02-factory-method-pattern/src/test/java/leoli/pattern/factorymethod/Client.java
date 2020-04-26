package leoli.pattern.factorymethod;

import org.junit.Test;

/**
 * 工厂方法模式测试
 *
 * @author leoli
 * @date 2020/4/26
 */
public class Client {

    @Test
    public void testFactoryMethod() {
        Creator creator = new ConcreteCretor();
        Product product = creator.createProduct(ConcreteProduct1.class);
        product.method1();
        product.method2();
    }

}