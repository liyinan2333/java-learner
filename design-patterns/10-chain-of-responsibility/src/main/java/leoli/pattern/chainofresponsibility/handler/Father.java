package leoli.pattern.chainofresponsibility.handler;

import leoli.pattern.chainofresponsibility.women.IWomen;

/**
 * 父亲类
 *
 * @author leoli
 * @date 2020/8/12
 */
public class Father extends Handler {

    public Father() {
        // 父亲只处理女儿的请求
        super(FATHER_LEVEL_REQUEST);
    }

    // 父亲的答复
    @Override
    protected void response(IWomen women) {
        System.out.println("女儿向父亲请示");
        System.out.println(women.getRequest());
        System.out.println("父亲的答复是：同意");
    }
}
