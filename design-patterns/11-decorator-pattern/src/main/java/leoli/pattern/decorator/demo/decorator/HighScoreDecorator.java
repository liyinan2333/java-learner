package leoli.pattern.decorator.demo.decorator;

import leoli.pattern.decorator.demo.schoolreport.SchoolReport;

/**
 * 最高成绩修饰
 *
 * @author leoli
 * @date 2020/8/12
 */
public class HighScoreDecorator extends Decorator {

    // 构造
    public HighScoreDecorator(SchoolReport sr) {
        super(sr);
    }

    // 我要汇报最高成绩
    private void reportHighScore() {
        System.out.println("这次考试语文最高是75，数学是78，自然是80");
    }

    @Override
    public void report() {
        // 我要在老爸看成绩单前告诉他最高成绩，否则等他一看，就抡起扫帚揍我，我哪里还有机会说啊
        reportHighScore();
        super.report();
    }
}
