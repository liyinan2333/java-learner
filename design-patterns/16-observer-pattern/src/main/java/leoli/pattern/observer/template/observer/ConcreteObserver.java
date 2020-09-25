package leoli.pattern.observer.template.observer;

/**
 * 具体观察者
 *
 * @author leoli
 * @date 2020/9/1
 */
public class ConcreteObserver implements Observer {

    //实现更新方法
    public void update() {

        System.out.println("观察者：接收到信息， 并进行处理！ ");

    }

}
