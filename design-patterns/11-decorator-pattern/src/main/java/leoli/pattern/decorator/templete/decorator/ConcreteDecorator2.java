package leoli.pattern.decorator.templete.decorator;

import leoli.pattern.decorator.templete.component.Component;

/**
 * 具体装饰者2
 *
 * @author leoli
 * @date 2020/8/12
 */
public class ConcreteDecorator2 extends Decorator {

    // 定义被装饰者
    public ConcreteDecorator2(Component component) {
        super(component);
    }

    // 定义自己的装饰方法
    private void method2() {
        System.out.println("method2 修饰");
    }

    // 重写父类的Operation方法
    @Override
    public void operate() {
        super.operate();
        this.method2();
    }
}
