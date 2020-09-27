package leoli.pattern.interpreter.template;

/**
 * 非终结符表达式
 *
 * @author leoli
 * @date 2020/9/27
 */
public class NonterminalExpression extends Expression {

    //每个非终结符表达式都会对其他表达式产生依赖
    public NonterminalExpression(Expression... expression) {
    }

    public Object interpreter(Context ctx) {
        //进行文法处理
        return null;
    }
}