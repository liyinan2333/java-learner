package leoli.pattern.proxy.dynamic.gamedemo;

import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.Date;

public class DynamicProxyGameDemoTest {

    @Test
    public void dynamicProxyTest() {
        // 定义一个玩家
        IGamePlayer player = new GamePlayer("张三");
        // 开始游戏，记下时间戳
        System.out.println("开始时间是：" + new Date());
        // 动态产生一个代理
        IGamePlayer proxy = (IGamePlayer)Proxy.newProxyInstance(player.getClass().getClassLoader(), player.getClass().getInterfaces(), new GamePlayIH(player));

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
