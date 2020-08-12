package leoli.pattern.decorator.templete.component;

/**
 * 具体构件
 *
 * @author leoli
 * @date 2020/8/12
 */
public class ConcreteComponent extends Component {

    // 具体实现
    @Override
    public void operate() {
        System.out.println("do something...");
    }
}
