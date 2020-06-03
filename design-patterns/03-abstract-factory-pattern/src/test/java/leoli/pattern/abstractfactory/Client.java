package leoli.pattern.abstractfactory;

import leoli.pattern.abstractfactory.factory.AbstractCreator;
import leoli.pattern.abstractfactory.factory.Creator1;
import leoli.pattern.abstractfactory.factory.Creator2;
import leoli.pattern.abstractfactory.product.AbstractProductA;
import leoli.pattern.abstractfactory.product.AbstractProductB;
import org.junit.Test;

/**
 * 抽象工厂模式Test
 *
 * @author leoli
 * @date 2020/6/3
 */
public class Client {

    @Test
    public void testAbstractFactory() {

        // 定义两个工厂
        AbstractCreator creator1 = new Creator1();
        AbstractCreator creator2 = new Creator2();

        // 生产A1对象
        AbstractProductA a1 = creator1.createProductA();
        AbstractProductA a2 = creator2.createProductA();
        AbstractProductB b1 = creator1.createProductB();
        AbstractProductB b2 = creator2.createProductB();
        a1.shareMethod();
        a1.doSomething();
        a2.shareMethod();
        a2.doSomething();
        b1.shareMethod();
        b1.doSomething();
        b2.shareMethod();
        b2.doSomething();
    }

}
