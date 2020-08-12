package decorator.demo;

import leoli.pattern.decorator.demo.decorator.HighScoreDecorator;
import leoli.pattern.decorator.demo.decorator.SortDecorator;
import leoli.pattern.decorator.demo.schoolreport.FouthGradeSchoolReport;
import leoli.pattern.decorator.demo.schoolreport.SchoolReport;

/**
 * 装饰模式 例子 演示
 *
 * @author leoli
 * @date 2020/8/12
 */
public class Father {

    public static void main(String[] args) {
        // 把成绩单拿过来
        SchoolReport sr;
        // 原装的成绩单
        sr = new FouthGradeSchoolReport();
        // 加了最高分说明的成绩单
        sr = new HighScoreDecorator(sr);
        // 加了成绩排名的说明
        sr = new SortDecorator(sr);
        // 看成绩单
        sr.report();
        // 然后老爸一看，很开心，就签名了
        sr.sign("老三");
    }

}
