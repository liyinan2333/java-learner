package leoli.pattern.bridge.demo.corp;

import leoli.pattern.bridge.demo.product.Product;

/**
 * 抽象公司类
 *
 * @author leoli
 * @date 2020/9/28
 */
public abstract class Corp {
    //定义一个抽象的产品对象， 不知道具体是什么产品
    private Product product;

    //构造函数， 由子类定义传递具体的产品进来
    public Corp(Product product) {
        this.product = product;
    }

    //公司是干什么的？赚钱的！
    public void makeMoney() {
        //每家公司都是一样， 先生产
        this.product.beProducted();
        //然后销售
        this.product.beSelled();
    }
}