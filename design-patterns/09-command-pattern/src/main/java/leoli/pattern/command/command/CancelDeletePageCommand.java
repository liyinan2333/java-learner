package leoli.pattern.command.command;

/**
 * 撤销删除一个页面的命令
 *
 * @author leoli
 * @date 2020/7/31
 */
public class CancelDeletePageCommand extends Command {
    @Override
    public void execute() {
        super.pg.rollBack();
    }
}
