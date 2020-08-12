package leoli.pattern.decorator.templete.decorator;

import leoli.pattern.decorator.templete.component.Component;

/**
 * 具体装饰者1
 *
 * @author leoli
 * @date 2020/8/12
 */
public class ConcreteDecorator1 extends Decorator {

    // 定义被装饰者
    public ConcreteDecorator1(Component component) {
        super(component);
    }

    // 定义自己的装饰方法
    private void method1() {
        System.out.println("method1 修饰");
    }

    // 重写父类的Operation方法
    @Override
    public void operate() {
        this.method1();
        super.operate();
    }
}
