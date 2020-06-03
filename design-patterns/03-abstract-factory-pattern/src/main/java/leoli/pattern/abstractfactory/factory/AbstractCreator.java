package leoli.pattern.abstractfactory.factory;

import leoli.pattern.abstractfactory.product.AbstractProductA;
import leoli.pattern.abstractfactory.product.AbstractProductB;

/**
 * 抽象工厂类
 *
 * @author leoli
 * @date 2020/6/3
 */
public abstract class AbstractCreator {

    // 创建A产品家族
    public abstract AbstractProductA createProductA();

    // 创建B产品家族
    public abstract AbstractProductB createProductB();

}
