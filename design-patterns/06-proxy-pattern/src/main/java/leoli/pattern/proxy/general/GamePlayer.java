package leoli.pattern.proxy.general;

/**
 * 普通代理的玩家
 */
public class GamePlayer implements IGamePlayer {

    String name = "";

    public GamePlayer(IGamePlayer _gamePlayer, String _name) throws Exception {
        if(_gamePlayer == null) {
            throw new Exception("不能创建真实角色! ");
        } else {
            this.name = _name;
        }
    }

    @Override
    public void login(String user, String password) {
        System.out.println("用户" + user + "登录成功！");
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
