package leoli.pattern.singleton.lazzy;

/**
 * 单例模式(懒汉模式，多线程高并发场景可能会有问题)
 * 确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例
 *
 * @author leoli
 * @date 2020/4/26
 */
public class Singleton {

    private static Singleton singleton;

    // 私有构造，限制产生多个对象
    private Singleton() {

    }

    // 通过该方法获得实例对象(synchronized关键字解决线程安全问题，确保只有一个实例)
    public synchronized static Singleton getSingleton() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    // 类中其他方法尽量是static
    public static void doSomething() {
        System.out.println("Do something...");
    }

}
