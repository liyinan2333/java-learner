package leoli.pattern.command;

import leoli.pattern.command.command.Command;
import leoli.pattern.command.command.DeletePageCommand;
import org.junit.Test;

/**
 * 命令模式测试类
 *
 * @author leoli
 * @date 2020/7/31
 */
public class CommandTest {

    @Test
    public void testCommandPattern() {
        //定义我们的接头人
        Invoker xiaoSan = new Invoker();
//        System.out.println("------------客户要求增加一项需求---------------");
        System.out.println("------------客户要求删除一个页面---------------");
        // 客户给我们下命令来
//        Command command = new AddRequirementCommand();
        Command command = new DeletePageCommand();
        // 接头人接收到命令
        xiaoSan.setCommand(command);
        // 接头人执行命令
        xiaoSan.action();
    }

}
