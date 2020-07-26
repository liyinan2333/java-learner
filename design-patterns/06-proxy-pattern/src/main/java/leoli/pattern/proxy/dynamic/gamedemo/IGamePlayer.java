package leoli.pattern.proxy.dynamic.gamedemo;

/**
 * 动态代理的玩家接口
 */
public interface IGamePlayer {

    // 登陆游戏
    public void login(String user, String password);

    // 打怪
    public void killBoss();

    // 升级
    public void upgrade();

}
