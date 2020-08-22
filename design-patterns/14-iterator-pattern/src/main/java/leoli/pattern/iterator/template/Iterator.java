package leoli.pattern.iterator.template;

/**
 * 抽象迭代器
 *
 * @author leoli
 * @date 2020/8/22
 */
public interface Iterator {

    //遍历到下一个元素
    public Object next();

    //是否已经遍历到尾部
    public boolean hasNext();

    //删除当前指向的元素
    public boolean remove();

}
