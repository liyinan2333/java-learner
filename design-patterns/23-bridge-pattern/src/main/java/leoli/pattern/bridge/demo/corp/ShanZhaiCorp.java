package leoli.pattern.bridge.demo.corp;

import leoli.pattern.bridge.demo.product.Product;

/**
 * 山寨公司
 *
 * @author leoli
 * @date 2020/9/28
 */
public class ShanZhaiCorp extends Corp {

    //产什么产品， 不知道， 等被调用的才知道
    public ShanZhaiCorp(Product product) {
        super(product);
    }

    //狂赚钱
    public void makeMoney() {
        super.makeMoney();
        System.out.println("我赚钱呀...");
    }
}