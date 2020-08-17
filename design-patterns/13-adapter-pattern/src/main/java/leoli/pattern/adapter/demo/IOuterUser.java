package leoli.pattern.adapter.demo;

import java.util.Map;

/**
 * @author leoli
 * @date 2020/8/17
 */
public interface IOuterUser {
    //基本信息， 比如名称、 性别、 手机号码等
    public Map getUserBaseInfo();

    //工作区域信息
    public Map getUserOfficeInfo();

    //用户的家庭信息
    public Map getUserHomeInfo();
}