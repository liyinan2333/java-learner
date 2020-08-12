package leoli.pattern.decorator.demo.schoolreport;

/**
 * 四年级成绩单
 *
 * @author leoli
 * @date 2020/8/12
 */
public class FouthGradeSchoolReport extends SchoolReport {

    // 我的成绩单
    @Override
    public void report() {
        /// 成绩单的格式是这个样子的
        System.out.println("尊敬的xxx家长：");
        System.out.println("    ......");
        System.out.println("    语文 62 数学 65 体育 98 自然 63");
        System.out.println("    ......");
        System.out.println("                            家长签名：         ");
    }

    // 家长签名
    @Override
    public void sign(String name) {
        System.out.println("家长签名我为：" + name);
    }
}
