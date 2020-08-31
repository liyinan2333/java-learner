package leoli.pattern.observer.demo;

import leoli.pattern.observer.demo.beobserver.HanFeiZi;
import leoli.pattern.observer.demo.observer.LiSi;
import leoli.pattern.observer.demo.observer.LiuSi;
import leoli.pattern.observer.demo.observer.Observer;
import leoli.pattern.observer.demo.observer.WangSi;
import org.junit.Test;

/**
 * 观察者模式 示例 演示
 *
 * @author leoli
 * @date 2020/8/30
 */
public class ObserverDemoTest {

    @Test
    public void observerDemoTest() throws InterruptedException {

        //三个观察者产生出来
        Observer liSi = new LiSi();
        Observer wangSi = new WangSi();
        Observer liuSi = new LiuSi();
        //定义出韩非子
        HanFeiZi hanFeiZi = new HanFeiZi();
        //我们后人根据历史，描述这个场景，有三个人在观察韩非子
        hanFeiZi.addObserver(liSi);
        hanFeiZi.addObserver(wangSi);
        hanFeiZi.addObserver(liuSi);
        //然后这里我们看看韩非子在干什么
        hanFeiZi.haveBreakfast();


    }

}