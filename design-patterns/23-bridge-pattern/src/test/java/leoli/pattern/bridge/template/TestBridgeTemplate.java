package leoli.pattern.bridge.template;

import junit.framework.TestCase;
import leoli.pattern.bridge.template.abstraction.Abstraction;
import leoli.pattern.bridge.template.abstraction.RefinedAbstraction;
import leoli.pattern.bridge.template.implementor.ConcreteImplementor1;
import org.junit.Test;

/**
 * 享元模式-通用模板-演示
 *
 * @author leoli
 * @date 2020/9/28
 */
public class TestBridgeTemplate extends TestCase {

    @Test
    public void testBridgeTemplate() {

        //定义一个实现化角色
        Implementor imp = new ConcreteImplementor1();
        //定义一个抽象化角色
        Abstraction abs = new RefinedAbstraction(imp);
        //执行行文
        abs.request();

    }

}
