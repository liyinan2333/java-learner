package leoli.pattern.iterator.demo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 迭代器模式 示例 演示
 *
 * @author leoli
 * @date 2020/8/22
 */
public class IteratorDemoTest {

    @Test
    public void iteratorDemoTest() {
        //定义一个List，存放所有的项目对象
        ArrayList<IProject> projects = new ArrayList<IProject>();
        //增加星球大战项目
        projects.add(new Project("星球大战项目", 10, 100000));
        //增加扭转时空项目
        projects.add(new Project("扭转时空项目", 100, 10000000));
        //增加超人改造项目
        projects.add(new Project("超人改造项目", 10000, 1000000000));
        //这边10个项目
        for (int i = 4; i < 14; i++) {
            projects.add(new Project("第" + i + "个项目", i * 5, i * 1000000));
        }
        //遍历一下ArrayList，把所有的数据都取出
//        projects.stream().forEach(project -> System.out.println(project.getProjectInfo()));
        Iterator<IProject> iterator = projects.iterator();
        while(iterator.hasNext()) {
            IProject project = iterator.next();
            System.out.println(project.getProjectInfo());
        }
    }

}
