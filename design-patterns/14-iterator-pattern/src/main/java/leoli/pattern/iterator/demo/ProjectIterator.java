package leoli.pattern.iterator.demo;

import java.util.ArrayList;

/**
 * 项目迭代器
 *
 * @author leoli
 * @date 2020/8/22
 */
public class ProjectIterator implements IProjectIterator {

    //所有的项目都放在ArrayList中
    private ArrayList<IProject> projects = new ArrayList<IProject>();
    private int currentItem = 0;

    //构造函数传入projectList
    public ProjectIterator(ArrayList<IProject> projectList) {
        this.projects = projectList;
    }

    //判断是否还有元素，必须实现
    @Override
    public boolean hasNext() {
    //定义一个返回值
        boolean b = true;
        if (this.currentItem >= projects.size() || this.projects.get(this.currentItem) == null) {
            b = false;
        }
        return b;
    }

    //取得下一个值
    @Override
    public IProject next() {
        return (IProject) this.projects.get(this.currentItem++);
    }

    //删除一个对象
    public void remove() {
        //暂时没有使用到
    }
}
