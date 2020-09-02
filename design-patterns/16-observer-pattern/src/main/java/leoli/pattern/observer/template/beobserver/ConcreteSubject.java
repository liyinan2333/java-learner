package leoli.pattern.observer.template.beobserver;

/**
 * 具体被观察者
 *
 * @author leoli
 * @date 2020/9/1
 */
public class ConcreteSubject extends Subject {

    //具体的业务
    public void doSomething() {
        System.out.println("被观察者：doSomething...");
        /*
         * do something
         */
        super.notifyObservers();
    }
}