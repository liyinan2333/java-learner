package leoli.pattern.interpreter.template;

/**
 * 抽象表达式
 *
 * @author leoli
 * @date 2020/9/27
 */
public abstract class Expression {

    //每个表达式必须有一个解析任务
    public abstract Object interpreter(Context ctx);

}
