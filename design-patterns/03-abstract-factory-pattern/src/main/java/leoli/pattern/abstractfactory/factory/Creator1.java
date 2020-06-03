package leoli.pattern.abstractfactory.factory;

import leoli.pattern.abstractfactory.product.AbstractProductA;
import leoli.pattern.abstractfactory.product.AbstractProductB;
import leoli.pattern.abstractfactory.product.ProductA1;
import leoli.pattern.abstractfactory.product.ProductB1;

/**
 * 产品等级为1的具体工厂类
 *
 * @author leoli
 * @date 2020/6/3
 */
public class Creator1 extends AbstractCreator {

    @Override
    public AbstractProductA createProductA() {
        // 只生产产品等级为1的A产品
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        // 只生产产品等级为1的B产品
        return new ProductB1();
    }
}
