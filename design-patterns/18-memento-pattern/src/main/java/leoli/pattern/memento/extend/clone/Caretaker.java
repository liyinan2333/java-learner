package leoli.pattern.memento.extend.clone;

/**
 * 备忘录管理员
 *
 * @author leoli
 * @date 2020/9/25
 */
public class Caretaker {
    //发起人对象
    private Originator originator;

    public Originator getOriginator() {
        return originator;
    }

    public void setOriginator(Originator originator) {
        this.originator = originator;
    }
}
