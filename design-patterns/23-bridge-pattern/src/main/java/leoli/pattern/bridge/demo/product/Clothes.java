package leoli.pattern.bridge.demo.product;

/**
 * 具体产品-衣服
 *
 * @author leoli
 * @date 2020/9/28
 */
public class Clothes extends Product {

    public void beProducted() {
        System.out.println("生产出的衣服是这样的...");
    }

    public void beSelled() {
        System.out.println("生产出的衣服卖出去了...");
    }

}