package leoli.pattern.adapter.demo;

import leoli.pattern.adapter.expand.IUserInfo;
import org.junit.Test;

/**
 * 适配器模式 示例演示
 *
 * @author leoli
 * @date 2020/8/17
 */
public class AdapterDemoTest {

    @Test
    public void adapterDemoTest() {
        System.out.println("----------没有外系统连接时-----------");
        //没有与外系统连接的时候， 是这样写的
        IUserInfo youngGirl1 = new UserInfo();
        //从数据库中查到11个
        for (int i = 0; i < 11; i++) {
            youngGirl1.getMobileNumber();
        }


        System.out.println("------------有外系统连接时-----------");
        //老板一想不对呀， 兔子不吃窝边草， 还是找借用人员好点
        //我们只修改了这句话
        IUserInfo youngGirl2 = new OuterUserInfo();
        //从数据库中查到11个
        for (int i = 0; i < 11; i++) {
            youngGirl2.getMobileNumber();
        }
    }

}
