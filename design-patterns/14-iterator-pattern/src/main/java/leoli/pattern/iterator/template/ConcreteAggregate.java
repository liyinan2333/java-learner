package leoli.pattern.iterator.template;

import java.util.Vector;

/**
 * 具体容器
 *
 * @author leoli
 * @date 2020/8/22
 */
public class ConcreteAggregate implements Aggregate {

    //容纳对象的容器
    private Vector vector = new Vector();

    //增加一个元素
    @Override
    public void add(Object object) {
        this.vector.add(object);
    }

    //返回迭代器对象
    @Override
    public Iterator iterator() {
        return new ConcreteIterator(this.vector);
    }

    //删除一个元素
    @Override
    public void remove(Object object) {
        this.remove(object);
    }


}
