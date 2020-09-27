package leoli.pattern.interpreter.demo;

import java.util.Map;

/**
 * 抽象表达式类
 *
 * @author leoli
 * @date 2020/9/27
 */
public abstract class Expression {

    //解析公式和数值， 其中var中的key值是公式中的参数， value值是具体的数字
    public abstract int interpreter(Map<String, Integer> var);

}