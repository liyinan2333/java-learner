package leoli.pattern.proxy.mandatory;

/**
 * 强制代理的真实角色
 */
public class GamePlayer implements IGamePlayer {

    private String name = "";
    // 我的代理是谁
    private IGamePlayer proxy = null;

    public GamePlayer(String _name) {
        this.name = _name;
    }

    @Override
    public void login(String user, String password) {
        if (this.isProxy()) {
            System.out.println("用户" + user + "登陆成功！");
        } else {
            System.out.println("请使用指定的代理访问！");
        }
    }

    @Override
    public void killBoss() {
        if (this.isProxy()) {
            System.out.println(this.name + "在打怪！");
        } else {
            System.out.println("请使用指定的代理访问!");
        }
    }

    @Override
    public void upgrade() {
        if (this.isProxy()) {
            System.out.println(this.name + "又升了一级！");
        } else{
            System.out.println("请使用指定的代理访问!");
        }
    }

    // 找到自己的代理
    @Override
    public IGamePlayer getProxy() {
        this.proxy = new GamePlayerProxy(this);
        return this.proxy;
    }

    private boolean isProxy() {
        return this.proxy != null;
    }
}
