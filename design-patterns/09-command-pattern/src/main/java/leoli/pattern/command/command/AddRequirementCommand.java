package leoli.pattern.command.command;

/**
 * 增加需求的命令
 *
 * @author leoli
 * @date 2020/7/31
 */
public class AddRequirementCommand extends Command {
    @Override
    public void execute() {
        // 找到需求组
        super.rg.find();
        // 增加一项需求
        super.rg.add();
        // 页面也要增加
        super.pg.add();
        // 代码也要增加
        super.cg.add();
        // 给出计划
        super.rg.plan();
    }
}
