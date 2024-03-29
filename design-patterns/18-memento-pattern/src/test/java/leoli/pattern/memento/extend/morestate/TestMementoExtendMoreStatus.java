package leoli.pattern.memento.extend.morestate;

import org.junit.Test;

/**
 * @author leoli
 * @date 2020/9/25
 */
public class TestMementoExtendMoreStatus {

    @Test
    public void testMementoExtendMoreStatus() {

        //定义出发起人
        Originator ori = new Originator();
        //定义出备忘录管理员
        Caretaker caretaker = new Caretaker();

        //初始化
        ori.setState1("中国");
        ori.setState2("强盛");
        ori.setState3("繁荣");
        System.out.println("===初始化状态===\n" + ori);

        //创建一个备忘录
        caretaker.setMemento(ori.createMemento());

        //修改状态值
        ori.setState1("软件");
        ori.setState2("架构");
        ori.setState3("优秀");
        System.out.println("\n===修改后状态===\n" + ori);

        //恢复一个备忘录
        ori.restoreMemento(caretaker.getMemento());
        System.out.println("\n===恢复后状态===\n" + ori);

    }

}
