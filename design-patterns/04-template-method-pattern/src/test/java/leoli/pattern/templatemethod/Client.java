package leoli.pattern.templatemethod;

import org.junit.Test;

/**
 * 模板方法模式Test
 *
 * @author leoli
 * @date 2020/6/3
 */
public class Client {

    @Test
    public void testTe1mplateMethod() {

        AbstractClass c1 = new ConcreteClass1();
        AbstractClass c2 = new ConcreteClass2();
        c1.templateMethod();
        c2.templateMethod();

    }

}
