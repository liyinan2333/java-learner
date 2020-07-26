package leoli.pattern.proxy.dynamic.gamedemo;

/**
 * 动态代理的真实角色
 */
public class GamePlayer implements IGamePlayer {

    private String name = "";

    public GamePlayer(String _name) {
        this.name = _name;
    }

    @Override
    public void login(String user, String password) {
            System.out.println("用户" + user + "登陆成功！");
    }

    @Override
    public void killBoss() {
        System.out.println(this.name + "在打怪！");
    }

    @Override
    public void upgrade() {
        System.out.println(this.name + "又升了一级！");
    }
}
