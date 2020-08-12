package leoli.pattern.decorator.templete.decorator;

import leoli.pattern.decorator.templete.component.Component;

/**
 * 抽象装饰者
 *
 * @author leoli
 * @date 2020/8/12
 */
public abstract class Decorator extends Component {

    private Component component = null;

    // 通过构造函数传递被装饰者
    public Decorator(Component component) {
        this.component = component;
    }

    // 委托给被装饰者执行
    @Override
    public void operate() {
        this.component.operate();
    }
}
