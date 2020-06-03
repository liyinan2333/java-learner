package leoli.pattern.builder.director;

import leoli.pattern.builder.builder.Builder;
import leoli.pattern.builder.product.ConcreteProduct;
import leoli.pattern.builder.product.Product;

/**
 * 导演类
 * 导演类起到封装的作用，避免高层模块深入到建造者内部的实现类。
 * 在建造者模式比较庞大时，导演类可以有多个。
 *
 * @author le]oli
 * @date 2020/6/3
 */
public class Director {

    private Builder builder = new ConcreteProduct();

    public Product getAProduct() {
        // 设置不同的零件，产生不同的产品
        builder.setPart();
        return builder.buildProduct();
    }

}
