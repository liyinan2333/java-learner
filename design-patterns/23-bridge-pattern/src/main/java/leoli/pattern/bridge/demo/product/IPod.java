package leoli.pattern.bridge.demo.product;

/**
 * 具体产品-IPod
 *
 * @author leoli
 * @date 2020/9/28
 */
public class IPod extends Product {

    public void beProducted() {
        System.out.println("生产出的iPod是这样的...");
    }

    public void beSelled() {
        System.out.println("生产出的iPod卖出去了...");
    }
}