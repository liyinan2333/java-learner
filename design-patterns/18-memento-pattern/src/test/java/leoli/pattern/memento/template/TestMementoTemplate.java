package leoli.pattern.memento.template;

import org.junit.Test;

/**
 * 备忘录模式-通用模板-演示
 *
 * @author leoli
 * @date 2020/9/25
 */
public class TestMementoTemplate {

    @Test
    public void testMementoTemplate() {

        //定义出发起人
        Originator originator = new Originator();
        //定义出备忘录管理员
        Caretaker caretaker = new Caretaker();
        //创建一个备忘录
        caretaker.setMemento(originator.createMemento());
        //恢复一个备忘录
        originator.restoreMemento(caretaker.getMemento());

    }

}
