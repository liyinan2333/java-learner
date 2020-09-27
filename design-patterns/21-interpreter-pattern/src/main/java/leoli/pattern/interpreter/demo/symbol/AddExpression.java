package leoli.pattern.interpreter.demo.symbol;

import leoli.pattern.interpreter.demo.Expression;

import java.util.Map;

/**
 * 加法解析器
 *
 * @author leoli
 * @date 2020/9/27
 */
public class AddExpression extends SymbolExpression {

    public AddExpression(Expression _left, Expression _right) {
        super(_left, _right);
    }

    //把左右两个表达式运算的结果加起来
    public int interpreter(Map<String, Integer> var) {
        return super.left.interpreter(var) + super.right.interpreter(var);
    }
}