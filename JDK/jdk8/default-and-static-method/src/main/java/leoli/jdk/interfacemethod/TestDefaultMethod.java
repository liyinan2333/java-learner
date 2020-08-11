package leoli.jdk.interfacemethod;

import leoli.jdk.interfacemethod.bean.Bird;
import leoli.jdk.interfacemethod.bean.Fish;

/**
 * 接口默认方法测试类
 *
 * @author leoli
 * @date 2020/8/11
 */
public class TestDefaultMethod {

    public static void main(String[] args) {

        Bird bird = new Bird();
        bird.fly();

        Fish fish = new Fish();
        fish.swim();
    }

}
