package leoli.pattern.observer.demo.beobserver;

import leoli.pattern.observer.demo.observer.Observer;

/**
 * 被观察者接口
 *
 * @author leoli
 * @date 2020/8/30
 */
public interface IHanFeiZi {

    //增加一个观察者
    public void addObserver(Observer observer);

    //删除一个观察者
    public void deleteObserver(Observer observer);

    //既然要观察，我发生改变了他也应该有所动作，通知观察者
    public void notifyObservers(String context);

}