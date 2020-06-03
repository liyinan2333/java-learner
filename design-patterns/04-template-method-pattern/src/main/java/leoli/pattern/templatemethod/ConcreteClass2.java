package leoli.pattern.templatemethod;

/**
 * 具体模板类2
 *
 * @author leoli
 * @date 2020/6/3
 */
public class ConcreteClass2 extends AbstractClass{

    @Override
    protected void doSomething() {
        System.out.println("2 -> doSomething...");
    }

    @Override
    protected void doAnything() {
        System.out.println("2 -> doAnything...");
    }
}
