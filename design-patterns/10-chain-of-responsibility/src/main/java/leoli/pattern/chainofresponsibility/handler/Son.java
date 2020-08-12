package leoli.pattern.chainofresponsibility.handler;

import leoli.pattern.chainofresponsibility.women.IWomen;

/**
 * 儿子类
 * 
 * @author leoli
 * @date 2020/8/12
 */
public class Son extends Handler {

    public Son() {
        // 儿子只处理母亲的请求
        super(SON_LEVEL_REQUEST);
    }

    // 父亲的答复
    @Override
    protected void response(IWomen women) {
        System.out.println("母亲向儿子请示");
        System.out.println(women.getRequest());
        System.out.println("儿子的答复是：同意");
    }
}
