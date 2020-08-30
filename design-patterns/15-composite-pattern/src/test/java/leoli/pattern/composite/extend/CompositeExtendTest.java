package leoli.pattern.composite.extend;

/**
 * 组合模式扩展-透明模式 演示
 *
 * @author leoli
 * @date 2020/8/30
 */
public class CompositeExtendTest {

    //通过递归遍历树
    public static void display(Component root) {
        for (Component c : root.getChildren()) {
            if (c instanceof Leaf) { //叶子节点
                c.doSomething();
            } else { //树枝节点
                display(c);
            }
        }
    }


}
