package leoli.pattern.interpreter.demo.var;

import leoli.pattern.interpreter.demo.Expression;
import java.util.Map;

/**
 * 变量解析器
 *
 * @author leoli
 * @date 2020/9/27
 */
public class VarExpression extends Expression {

    private String key;

    public VarExpression(String _key) {
        this.key = _key;
    }

    //从map中取之
    public int interpreter(Map<String, Integer> var) {
        return var.get(this.key);
    }
}