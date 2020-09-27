package leoli.pattern.interpreter.template;

import org.junit.Test;

import java.util.Stack;

/**
 * 解释器模式-通用模板-演示
 *
 * @author leoli
 * @date 2020/9/27
 */
public class TestInterpreterTemplate {

    @Test
    public void testInterpreterTemplate() {
        Context ctx = new Context();
        //通常定一个语法容器， 容纳一个具体的表达式， 通常为ListArray、 LinkedList、 Stack等类型
        Stack<Expression > stack = null;

        for (; ; ) {
            //进行语法判断， 并产生递归调用
        }

        //产生一个完整的语法树，由各个具体的语法分析进行解析
//        Expression exp = stack.pop();

        //具体元素进入场景
//        exp.interpreter(ctx);
    }

}
