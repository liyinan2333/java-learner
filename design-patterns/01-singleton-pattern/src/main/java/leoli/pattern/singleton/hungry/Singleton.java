package leoli.pattern.singleton.hungry;

/**
 * 单例模式(饿汉模式)
 * 确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例
 *
 * @author leoli
 * @date 2020/4/26
 */
public class Singleton {

    private static final Singleton singleton = new Singleton();

    // 私有构造，限制产生多个对象
    private Singleton() {

    }

    // 通过该方法获得实例对象
    public static Singleton getSingleton() {
        return singleton;
    }

    // 类中其他方法尽量是static
    public static void doSomething() {

        System.out.println("Do something...");

    }

}
