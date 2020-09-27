package leoli.pattern.state.template;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * 状态模式-通用模板-演示
 *
 * @author leoli
 * @date 2020/9/27
 */
public class TestStateTemplate extends TestCase {

    @Test
    public void testStateTemplate() {

        //定义环境角色
        Context context = new Context();

        //初始化状态
        context.setCurrentState(new ConcreteState1());

        //行为执行
        context.handle1();
        context.handle2();
    }

}