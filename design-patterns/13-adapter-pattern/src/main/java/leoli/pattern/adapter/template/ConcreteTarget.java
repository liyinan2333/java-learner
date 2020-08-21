package leoli.pattern.adapter.template;

/**
 * @author leoli
 * @date 2020/8/21
 */
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("If you need any help, pls call me!");
    }
}
