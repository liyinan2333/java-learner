package leoli.pattern.command.command;

/**
 * 删除页面的命令
 *
 * @author leoli
 * @date 2020/7/31
 */
public class DeletePageCommand extends Command {
    @Override
    public void execute() {
        //找到页面组
        super.pg.find();
        // 删除一个页面
        super.rg.delete();
        // 给出计划
        super.rg.plan();
    }
}
