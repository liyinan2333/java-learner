package leoli.pattern.adapter.template;

/**
 * @author leoli
 * @date 2020/8/21
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {

        super.doSomething();

    }
}
