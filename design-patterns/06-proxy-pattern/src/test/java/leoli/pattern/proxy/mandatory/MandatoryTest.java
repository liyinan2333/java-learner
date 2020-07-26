package leoli.pattern.proxy.mandatory;
import leoli.pattern.proxy.mandatory.GamePlayer;
import leoli.pattern.proxy.mandatory.GamePlayerProxy;
import leoli.pattern.proxy.mandatory.IGamePlayer;
import org.junit.Test;

import java.util.Date;

/**
 * 强制代理测试类
 */
public class MandatoryTest {

    /**
     * 测试1：不使用代理，直接访问
     */
    @Test
    public void mandatoryProxyTest1() {
        IGamePlayer player = new GamePlayer("张三");
        // 开始打游戏，记下时间戳
        System.out.println("开始时间：" + new Date());
        player.login("zhangsan", "password");
        player.killBoss();
        player.upgrade();
        // 记录游戏结束时间
        System.out.println("结束时间：" + new Date());
    }

    @Test
    public void mandatoryProxyTest2() {
        // 玩家
        IGamePlayer player = new GamePlayer("张三");
        // 代练
        IGamePlayer proxy = new GamePlayerProxy(player);
        // 开始打游戏，记下时间戳
        System.out.println("开始时间是：" + new Date());
        // 登录
        proxy.login("zhangsan", "password");
        // 开始打怪
        proxy.killBoss();
        // 升级
        proxy.upgrade();
        // 记录游戏结束时间
        System.out.println("结束时间是：" + new Date());
    }

    @Test
    public void mandatoryProxyTest3() {
        // 定义一个玩家
        IGamePlayer player = new GamePlayer("张三");
        // 获得指定的代理
        IGamePlayer proxy = player.getProxy();
        // 开始打游戏，记下时间戳
        System.out.println("开始时间是：" + new Date());
        // 登录
        proxy.login("zhangsan", "password");
        // 开始打怪
        proxy.killBoss();
        // 升级
        proxy.upgrade();
        // 开始打怪
        proxy.killBoss();
        // 升级
        proxy.upgrade();
        // 记录游戏结束时间
        System.out.println("结束时间是：" + new Date());

    }

}
