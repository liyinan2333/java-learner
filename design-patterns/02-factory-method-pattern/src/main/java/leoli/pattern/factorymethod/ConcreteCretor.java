package leoli.pattern.factorymethod;

/**
 * 具体工厂类
 *
 * @author leoli
 * @date 2020/4/26
 */
public class ConcreteCretor extends Creator {

    public <T extends Product> T createProduct(Class<T> c) {
        Product product = null;
        try {
            product = (Product)Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            System.out.println("异常处理...");
        }
        return (T)product;
    }

}
