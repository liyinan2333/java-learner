package leoli.pattern.command.command;

import leoli.pattern.command.group.CodeGroup;
import leoli.pattern.command.group.PageGroup;
import leoli.pattern.command.group.RequirementGroup;

/**
 * 抽象命令类
 *
 * @author leoli
 * @date 2020/7/31
 */
public abstract class Command {

    // 需求组
    protected RequirementGroup rg = new RequirementGroup();
    // 美工组
    protected PageGroup pg = new PageGroup();
    // 代码组
    protected CodeGroup cg = new CodeGroup();

    // 只有一个方法，你要我做什么事情
    public abstract void execute();

}
