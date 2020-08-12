package leoli.pattern.decorator.demo.schoolreport;

/**
 * 抽象成绩单
 *
 * @author leoli
 * @date 2020/8/12
 */
public abstract class SchoolReport {

    // 成绩单主要展示的是你的成绩情况
    public abstract void report();
    // 成绩单需要家长签字，这个是最要命的
    public abstract void sign(String name);

}
