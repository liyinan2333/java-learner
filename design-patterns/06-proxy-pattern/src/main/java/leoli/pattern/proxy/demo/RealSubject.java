package leoli.pattern.proxy.demo;

/**
 * 真实主题类
 */
public class RealSubject implements Subject {
    public void request() {
        System.out.println("业务逻辑处理...");
    }
}
