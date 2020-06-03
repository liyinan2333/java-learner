package leoli.pattern.builder.product;

import leoli.pattern.builder.builder.Builder;

/**
 * @author leoli
 * @date 2020/6/3
 */
public class ConcreteProduct extends Builder {

    private Product product = new Product();

    @Override
    public void setPart() {
        // 产品内的逻辑处理(设置不同的零件)
    }

    @Override
    public Product buildProduct() {
        // 构建一个产品
        return product;
    }
}
