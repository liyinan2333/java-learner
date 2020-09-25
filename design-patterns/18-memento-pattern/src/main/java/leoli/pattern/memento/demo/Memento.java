package leoli.pattern.memento;

/**
 * 备忘录
 *
 * @author leoli
 * @date 2020/9/25
 */
public class Memento {
    //男孩的状态
    private String state = "";

    //通过构造函数传递状态信息
    public Memento(String _state) {
        this.state = _state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}