package leoli.jdk.interfacemethod;

import leoli.jdk.interfacemethod.bean.Bird;
import leoli.jdk.interfacemethod.bean.Fish;
import leoli.jdk.interfacemethod.imp.Animal;
import leoli.jdk.interfacemethod.imp.AnimalFactory;

/**
 * 接口静态方法测试类
 *
 * @author leoli
 * @date 2020/8/11
 */
public class TestStaticMethod {

    public static void main(String[] args) {

        // 生产一只鸟
        Animal bird = AnimalFactory.create(Bird::new);
        bird.fly();
        // 生产一条鱼
        Animal fish = AnimalFactory.create(Fish::new);
        fish.swim();
    }

}
