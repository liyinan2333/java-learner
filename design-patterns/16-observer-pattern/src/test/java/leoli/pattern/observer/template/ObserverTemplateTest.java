package leoli.pattern.observer.template;

import leoli.pattern.observer.template.beobserver.ConcreteSubject;
import leoli.pattern.observer.template.observer.ConcreteObserver;
import leoli.pattern.observer.template.observer.Observer;
import org.junit.Test;

/**
 * 观察者模式 通用模板 演示
 *
 * @author leoli
 * @date 2020/9/1
 */
public class ObserverTemplateTest {

    @Test
    public void observerTemplateTest() {

        //创建一个被观察者
        ConcreteSubject subject = new ConcreteSubject();
        //定义一个观察者
        Observer obs = new ConcreteObserver();
        //观察者观察被观察者
        subject.addObserver(obs);
        //观察者开始活动了
        subject.doSomething();

    }

}