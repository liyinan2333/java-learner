package leoli.pattern.flyweight.extend.threadsafe;

import org.junit.Test;

/**
 * 享元模式线程安全问题-演示
 *
 * @author leoli
 * @date 2020/9/28
 */
public class TestThreadSafe {

    @Test
    public void testThreadSafe() throws InterruptedException {
        //在对象池中初始化4个对象
        SignInfoFactory.getSignInfo("科目1");
        SignInfoFactory.getSignInfo("科目2");
        SignInfoFactory.getSignInfo("科目3");
        SignInfoFactory.getSignInfo("科目4");

        //取得对象
        SignInfo signInfo = SignInfoFactory.getSignInfo("科目2");
        while (true) {
            signInfo.setId("ZhangSan");
            signInfo.setLocation("ZhangSan");
            (new MultiThread(signInfo)).start();
            signInfo.setId("LiSi");
            signInfo.setLocation("LiSi");
            (new MultiThread(signInfo)).start();

            Thread.sleep(1000);
        }
    }

}