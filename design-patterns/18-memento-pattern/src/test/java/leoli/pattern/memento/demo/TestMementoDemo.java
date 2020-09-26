package leoli.pattern.memento.demo;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * 备忘录模式Demo-演示
 *
 * @author leoli
 * @date 2020/9/25
 */
public class TestMementoDemo extends TestCase {

    @Test
    public void testMementoDemo() {

        //声明出主角
        Boy boy = new Boy();
        //声明出备忘录的管理者
        Caretaker caretaker = new Caretaker();

        //初始化当前状态
        boy.setState("心情很棒！ ");
        System.out.println("=====男孩现在的状态======");
        System.out.println(boy.getState());

        //需要记录下当前状态呀
        caretaker.setMemento(boy.createMemento());

        //男孩去追女孩， 状态改变
        boy.changeState();
        System.out.println("\n=====男孩追女孩子后的状态======");
        System.out.println(boy.getState());

        //追女孩失败， 恢复原状
        boy.restoreMemento(caretaker.getMemento());
        System.out.println("\n=====男孩恢复后的状态======");
        System.out.println(boy.getState());
    }

}