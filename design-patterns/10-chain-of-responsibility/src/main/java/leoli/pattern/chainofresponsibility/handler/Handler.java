package leoli.pattern.chainofresponsibility.handler;

import leoli.pattern.chainofresponsibility.women.IWomen;

/**
 * 男性抽象类
 *
 * @author leoli
 * @date 2020/8/12
 */
public abstract class Handler {

    public final static int FATHER_LEVEL_REQUEST = 1;
    public final static int HUSBAND_LEVEN_REQUEST = 2;
    public final static int SON_LEVEL_REQUEST = 3;
    // 能处理的级别
    private int level = 0;
    // 责任传递，下一个责任人是谁
    private Handler nextHandler;

    // 每个类都要说明一下自己能处理哪些请求
    public Handler(int _level) {
        this.level = _level;
    }

    // 一个女性（女儿、妻子或母亲）要求逛街，你要处理这个请求，注意这里的final关键字
    public final void handleMessage(IWomen women) {
        if (women.getType() == this.level) {
            this.response(women);
        } else {
            // 有后续环节，才把请求往后递送
            if (this.nextHandler != null) {
                this.nextHandler.handleMessage(women);
            } else {
                // 已经没有后续处理人了，不用处理了
                System.out.println("---没地方请示了，按不同意处理---");
            }
        }
    }

    /*
     * 如果不属于你处理的请求，你应该让她找下一个环节的人，如女儿出嫁了，
     * 还向父亲请示是否可以逛街，那父亲应该告诉女儿，应该找丈夫请示
     */
    public void setNext(Handler _handler) {
        this.nextHandler = _handler;
    }

    // 又请示那当然要回应
    protected abstract void response(IWomen women);
}
