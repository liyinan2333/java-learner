package leoli.pattern.memento.extend.clone;

import org.junit.Test;

/**
 * 克隆+发起人融合备忘录-演示
 *
 * @author leoli
 * @date 2020/9/25
 */
public class TestMementoExtendClone {

    @Test
    public void testMementoExtendClone() {

        //定义发起人
        Originator originator = new Originator();

        //建立初始状态
        originator.setState("初始状态...");
        System.out.println("初始状态是： " + originator.getState());

        //建立备份
        originator.createMemento();

        //修改状态
        originator.setState("修改后的状态...");
        System.out.println("修改后状态是： " + originator.getState());

        //恢复原有状态
        originator.restoreMemento();
        System.out.println("恢复后状态是： " + originator.getState());

    }

}
