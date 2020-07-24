package leoli.pattern.proxy.general;

import org.junit.Test;

import java.util.Date;

/**
 * 普通代理模式测试
 */
public class GeneralProxyTest {

    @Test
    public void generalProxyTest() {

        // 定义一个代练，传入要对谁进行代练
        IGamePlayer proxy = new GamePlayerProxy("张三");
        // 开始打游戏，记下时间戳
        System.out.println("开始时间是：" + new Date());
        // 登录
        proxy.login("zhangsan", "password");
        // 打怪
        proxy.killBoss();
        // 升级
        proxy.upgrade();
        // 记录游戏结束时间
        System.out.println("结束时间是：" + new Date());

    }

}
