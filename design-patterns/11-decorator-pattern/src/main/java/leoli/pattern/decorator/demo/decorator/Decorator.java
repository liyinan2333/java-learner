package leoli.pattern.decorator.demo.decorator;

import leoli.pattern.decorator.demo.schoolreport.SchoolReport;

/**
 * @author leoli
 * @date 2020/8/12
 */
public class Decorator extends SchoolReport {

    // 首先我要直到是哪个成绩单
    private SchoolReport sr;

    // 构造，传递成绩单过来
    public Decorator(SchoolReport sr) {
        this.sr = sr;
    }

    @Override
    public void report() {
        // 成绩单还是要被看到的
        this.sr.report();
    }

    @Override
    public void sign(String name) {
        // 看完还是要签名的
        this.sr.sign(name);
    }

}
