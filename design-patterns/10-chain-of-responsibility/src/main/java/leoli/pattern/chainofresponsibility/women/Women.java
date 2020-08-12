package leoli.pattern.chainofresponsibility.women;

import lombok.Data;

/**
 * 女性类
 *
 * @author leoli
 * @date 2020/8/12
 */
@Data
public class Women implements IWomen {

    /*
     * 通过一个int类型的参数来描述妇女的个人状况
     * 1-未出嫁、2-出嫁、3-夫死
     */
    private int type = 1;
    // 妇女的请示
    private String request = "";
    // 构造函数传递过来请求
    public Women(int _type, String _request) {
        this.type = _type;
        // 为了便于显示，在这里做了点处理
        switch (this.type) {
            case 1 -> this.request="女儿的请求是：" + _request;
            case 2 -> this.request="妻子的请求是：" + _request;
            case 3 -> this.request="母亲的请求是：" + _request;
            default -> this.request="不知道什么人的请求：" + _request;
        }
    }
    //获得自己的状况
    @Override
    public int getType() {
        return this.type;
    }
    // 获得妇女的请求
    @Override
    public String getRequest() {
        return this.request;
    }

}
