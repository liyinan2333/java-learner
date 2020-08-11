package leoli.jdk.interfacemethod.bean;

import leoli.jdk.interfacemethod.imp.Animal;

/**
 * @author leoli
 * @date 2020/8/11
 */
public class Bird implements Animal {

    public void fly() {
        System.out.println("Bird类中的fly方法：birds can fly...");
    }

}
