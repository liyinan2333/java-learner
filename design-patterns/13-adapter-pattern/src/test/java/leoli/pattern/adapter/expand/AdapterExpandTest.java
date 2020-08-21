package leoli.pattern.adapter.expand;

import leoli.pattern.adapter.expand.impl.IOuterUserBaseInfo;
import leoli.pattern.adapter.expand.impl.IOuterUserHomeInfo;
import leoli.pattern.adapter.expand.impl.IOuterUserOfficeInfo;
import org.junit.Test;

/**
 * 适配器扩展 演示
 *
 * @author leoli
 * @date 2020/8/22
 */
public class AdapterExpandTest {

    @Test
    public void adapterExpandTest() {

        //外系统的人员信息
        IOuterUserBaseInfo baseInfo = new OuterUserBaseInfo();
        IOuterUserHomeInfo homeInfo = new OuterUserHomeInfo();
        IOuterUserOfficeInfo officeInfo = new OuterUserOfficeInfo();

        //传递三个对象
        IUserInfo youngGirl = new OuterUserInfo(baseInfo, homeInfo, officeInfo);

        //从数据库中查到11个
        for (int i = 0; i < 11; i++) {
            youngGirl.getMobileNumber();
        }


    }

}
