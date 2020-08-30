package leoli.pattern.composite.extend;

import java.util.ArrayList;

/**
 * 树叶节点
 *
 * @author leoli
 * @date 2020/8/30
 */
public class Leaf extends Component {

    @Override
    @Deprecated
    public void add(Component component) {
        //空实现,直接抛弃一个"不支持请求"异常
        throw new UnsupportedOperationException();

    }

    @Override
    @Deprecated
    public void remove(Component component) {
        //空实现
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public ArrayList<Component> getChildren() {
        //空实现
        throw new UnsupportedOperationException();
    }

}
