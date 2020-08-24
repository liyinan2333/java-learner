package leoli.pattern.composite.demo;

/**
 * 树叶
 *
 * @author leoli
 * @date 2020/8/22
 */
public class Leaf extends Corp {

    //通过一个构造函数传递小兵的信息
    public Leaf(String _name, String _position, int _salary) {
        super(_name, _position, _salary);
    }

}
