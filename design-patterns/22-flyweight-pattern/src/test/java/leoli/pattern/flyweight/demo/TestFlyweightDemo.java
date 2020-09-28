package leoli.pattern.flyweight.demo;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 享元模式-demo-演示
 *
 * @author leoli
 * @date 2020/9/28
 */
public class TestFlyweightDemo extends TestCase {

    @Test
    public void testFlyweightDemo() {

        //初始化对象池
        for (int i = 0; i < 3; i++) {
            String subject = "科目" + i;
            //初始化地址
            for (int j = 0; j < 2; j++) {
                String key = subject + "考试地点" + j;
                SignInfoFactory.getSignInfo(key);
            }
        }
        SignInfo signInfo = SignInfoFactory.getSignInfo("科目1考试地点1");

    }

}