package leoli.pattern.chainofresponsibility.handler;

import leoli.pattern.chainofresponsibility.women.IWomen;

/**
 * 丈夫类
 *
 * @author leoli
 * @date 2020/8/12
 */
public class Husband extends Handler {

    public Husband() {
        // 丈夫只处理妻子的请求
        super(HUSBAND_LEVEN_REQUEST);
    }

    // 父亲的答复
    @Override
    protected void response(IWomen women) {
        System.out.println("妻子向丈夫请示");
        System.out.println(women.getRequest());
        System.out.println("丈夫的答复是：同意");
    }
}
