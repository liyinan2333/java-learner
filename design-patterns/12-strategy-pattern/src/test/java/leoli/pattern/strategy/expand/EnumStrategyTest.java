package leoli.pattern.strategy.expand;

import java.util.Arrays;

/**
 * 策略模式扩展：枚举策略 演示
 *
 * @author leoli
 * @date 2020/8/17
 */
public class EnumStrategyTest {

    public static void main(String[] args) {
        //输入的两个参数是数字
        int a = Integer.parseInt(args[0]);
        String symbol = args[1]; //符号
        int b = Integer.parseInt(args[2]);
        System.out.println("输入的参数为： " + Arrays.toString(args));
        System.out.println("运行结果为： " + a + symbol + b + "=" + Calculator.ADD.exec(a,b));
    }

}