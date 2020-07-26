package leoli.pattern.proxy.dynamic;

/**
 * 前置通知类
 */
public class BeforeAdvice implements IAdvice {
    @Override
    public void exec() {
        System.out.println("我是前置通知，我被执行了！");
    }
}
