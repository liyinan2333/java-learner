package leoli.pattern.proxy.dynamic;

/**
 * 真实主题
 */
public class RealSubject implements Subject {

    @Override
    public void doSomething(String str) {
        System.out.println("doSomething --> " + str);
    }
}
