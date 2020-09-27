package leoli.pattern.interpreter.demo.symbol;

import leoli.pattern.interpreter.demo.Expression;

import java.util.Map;

/**
 * 减法解析器
 *
 * @author leoli
 * @date 2020/9/27
 */
public class SubExpression extends SymbolExpression {

    public SubExpression(Expression _left, Expression _right) {
        super(_left, _right);
    }

    //左右两个表达式相减
    public int interpreter(Map<String, Integer> var) {
        return super.left.interpreter(var) - super.right.interpreter(var);
    }
}