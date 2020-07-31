package leoli.pattern.command.group;

/**
 * 代码组
 *
 * @author leoli
 * @date 2020/7/31
 */
public class CodeGroup extends Group {
    // 客户要求代码组过去和他们谈
    public void find() {
        System.out.println("找到代码组...");
    }

    public void add() {
        System.out.println("客户要求增加一项功能...");
    }

    public void delete() {
        System.out.println("客户要求删除一项功能...");
    }

    public void change() {
        System.out.println("客户要求修改一项功能...");
    }

    public void plan() {
        System.out.println("客户要求代码变更计划...");
    }
}
