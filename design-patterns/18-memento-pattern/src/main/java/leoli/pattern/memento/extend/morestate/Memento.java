package leoli.pattern.memento.extend.morestate;

import java.util.HashMap;

/**
 * 备忘录
 *
 * @author leoli
 * @date 2020/9/25
 */
public class Memento {

    //接受HashMap作为状态
    private java.util.HashMap<String, Object> stateMap;

    //接受一个对象， 建立一个备份
    public Memento(HashMap<String, Object> map) {
        this.stateMap = map;
    }

    public HashMap<String, Object> getStateMap() {
        return stateMap;
    }

    public void setStateMap(HashMap<String, Object> stateMap) {
        this.stateMap = stateMap;
    }
}