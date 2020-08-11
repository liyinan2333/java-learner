package leoli.jdk.interfacemethod.imp;

/**
 * default method interface
 *
 * @author leoli
 * @date 2020/8/11
 */
public interface Animal {

    default void fly() {
        System.out.println("birds can fly...");
    }

    default void swim() {
        System.out.println("fishes can swim......");
    }

}