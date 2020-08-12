package leoli.pattern.decorator.demo.decorator;

import leoli.pattern.decorator.demo.schoolreport.SchoolReport;

/**
 * @author leoli
 * @date 2020/8/12
 */
public class SortDecorator extends Decorator {

    // 构造
    public SortDecorator(SchoolReport sr) {
        super(sr);
    }

    // 告诉老爸学校的排名情况
    private void reportSort() {
        System.out.println("我是排名第38名...");
    }

    @Override
    public void report() {
        super.report();
        // 老爸看完成绩单后再告诉他，加强作用
        this.reportSort();
    }
}
