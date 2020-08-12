package chainofresponsibility;

import leoli.pattern.chainofresponsibility.handler.Father;
import leoli.pattern.chainofresponsibility.handler.Handler;
import leoli.pattern.chainofresponsibility.handler.Husband;
import leoli.pattern.chainofresponsibility.handler.Son;
import leoli.pattern.chainofresponsibility.women.IWomen;
import leoli.pattern.chainofresponsibility.women.Women;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 责任链模式测试
 *
 * @author leoli
 * @date 2020/8/12
 */
public class ChainOfResponsibilityTest {

    @Test
    public void testChainOfResponsibility() {
        // 随机挑选几个女性
        Random rand = new Random();
        List<IWomen> womens = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            womens.add(new Women(rand.nextInt(3), "我要出去逛街"));
        }
        // 定义三个请示对象
        Handler father = new Father();
        Handler husband = new Husband();
        Handler son = new Son();
        // 设置请示顺序
        father.setNext(husband);
        husband.setNext(son);
        for (IWomen women : womens) {
            System.out.println("-------------------------------------------------------");
            System.out.println(women);
            father.handleMessage(women);
        }
    }

}
