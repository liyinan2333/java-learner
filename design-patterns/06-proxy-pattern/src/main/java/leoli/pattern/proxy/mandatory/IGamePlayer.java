package leoli.pattern.proxy.mandatory;

/**
 * 强制代理的玩家接口
 */
public interface IGamePlayer {

    // 登陆游戏
    public void login(String user, String password);

    // 打怪
    public void killBoss();

    // 升级
    public void upgrade();

    // 每个人都可以找一下自己的代理
    public IGamePlayer getProxy();

}
