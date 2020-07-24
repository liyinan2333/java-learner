package leoli.pattern.proxy.demo;

/**
 * 代理类
 */
public class Proxy implements Subject {
    // 要代理哪个实现类
    private Subject subject = null;
    // 默认被代理者
    public Proxy() {
        this.subject = new RealSubject();
    }
    // 通过构造函数传递代理者
    public Proxy(Subject subject) {
        this.subject = subject;
    }
    // 实现接口中定义的方法
    public void request() {
        this.before();
        this.subject.request();
        this.after();
    }

    private void before() {
        System.out.println("Before...");
    }

    private void after() {
        System.out.println("After...");
    }
}
