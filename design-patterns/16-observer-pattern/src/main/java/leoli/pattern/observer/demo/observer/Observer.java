package leoli.pattern.observer.demo.observer;

/**
 * @author leoli
 * @date 2020/8/30
 */
public interface Observer {

    //一发现别人有动静，自己也要行动起来
    public void update(String context);

}
