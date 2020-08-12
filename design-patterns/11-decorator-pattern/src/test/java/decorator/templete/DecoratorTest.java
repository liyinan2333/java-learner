package decorator.templete;

import leoli.pattern.decorator.templete.component.Component;
import leoli.pattern.decorator.templete.component.ConcreteComponent;
import leoli.pattern.decorator.templete.decorator.ConcreteDecorator1;
import leoli.pattern.decorator.templete.decorator.ConcreteDecorator2;

/**
 * 装饰模式 通用模板 演示
 *
 * @author leoli
 * @date 2020/8/12
 */
public class DecoratorTest {

    public static void main(String[] args) {

        Component component = new ConcreteComponent();

        // 第一次修饰
        component = new ConcreteDecorator1(component);
        // 第二次修饰
        component = new ConcreteDecorator2(component);
        // 修饰后运行
        component.operate();

    }

}
