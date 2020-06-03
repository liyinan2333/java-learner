package leoli.pattern.builder.builder;

import leoli.pattern.builder.product.Product;

/**
 * 抽象建造者
 *
 * @author leoli
 * @date 2020/6/3
 */
public abstract class Builder {

    // 设置产品的不同部分，以获得不同的产品
    public abstract void setPart();

    // 建造产品
    public abstract Product buildProduct();

}
