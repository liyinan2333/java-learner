package leoli.pattern.proxy.dynamic;

/**
 * 具体业务的动态代理
 */
public class SubjectDynamicProxy extends DynamicProxy {

    public static <T> T newProxyInstance(Subject subject) {

        return newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), new MyInvocationHandler(subject));

    }

}
