package leoli.pattern.templatemethod;

/**
 * 具体模板类1
 *
 * @author leoli
 * @date 2020/6/3
 */
public class ConcreteClass1 extends AbstractClass{

    @Override
    protected void doSomething() {
        System.out.println("1 -> doSomething...");
    }

    @Override
    protected void doAnything() {
        System.out.println("1 -> doAnything...");
    }
}
