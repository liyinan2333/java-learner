package leoli.pattern.interpreter.demo;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.*;

/**
 * 解释器模式-Demo-演示
 *
 * @author leoli
 * @date 2020/9/27
 */
@RunWith(Parameterized.class)
public class TestInterpreterDemo extends TestCase {

    @Parameterized.Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(new Object[][]{
                {"a+b+c", new HashMap<>() {{
                    put("a", 100);
                    put("b", 20);
                    put("c", 10);
                }}, 130},
                {"a+b", new HashMap<>() {{
                    put("a", 10);
                    put("b", 3);
                }}, 11}
        });
    }

    private String expStr;
    private Map params;
    private Integer answer;

    public TestInterpreterDemo(String expStr, Map params, Integer answer) {
        this.expStr = expStr;
        this.params = params;
        this.answer = answer;
    }

    //运行四则运算
    @Test
    public void testInterpreterDemo() throws IOException {

        System.out.print("请输入表达式： ");
        Calculator cal = new Calculator(expStr);
        System.out.println(expStr);

        System.out.println("\n请输入参数值：");
        Set<String> set = params.keySet();
        for (String param : set) {
            System.out.println(param + " = " + params.get(param));
        }

        int calAnswer = cal.run(params);
        System.out.println("\n运算结果为： " + expStr + " = " + calAnswer);

        Assert.assertTrue(this.answer == calAnswer);
        System.out.println("\n===============================================\n");

    }
}