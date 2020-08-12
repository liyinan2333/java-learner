package leoli.pattern.chainofresponsibility.women;

/**
 * 女性接口
 *
 * @author leoli
 * @date 2020/8/12
 */
public interface IWomen {

    // 获得个人情况
    public int getType();
    // 获得个人请示，你要干什么？出去逛街？约会？还是看电影？
    public String getRequest();

}
