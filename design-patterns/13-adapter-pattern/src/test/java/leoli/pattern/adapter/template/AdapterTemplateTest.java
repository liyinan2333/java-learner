package leoli.pattern.adapter.template;

import org.junit.Test;

/**
 * @author leoli
 * @date 2020/8/21
 */
public class AdapterTemplateTest {

    @Test
    public void adapterTemplateTest() {

        // 原有的业务逻辑
        Target target = new ConcreteTarget();
        target.request();
        // 现在增加了适配器角色后的业务逻辑
        Target target2 = new Adapter();
        target2.request();

    }


}
