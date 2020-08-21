package leoli.pattern.adapter.expand;

import leoli.pattern.adapter.expand.impl.IOuterUserHomeInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * 员工的家庭信息
 *
 * @author leoli
 * @date 2020/8/22
 */
public class OuterUserHomeInfo implements IOuterUserHomeInfo {


    @Override
    public Map getUserHomeInfo() {

        HashMap homeInfo = new HashMap();
        homeInfo.put("homeTelNumber", "员工的家庭电话是...");
        homeInfo.put("homeAddress", "员工的家庭地址是...");

        return homeInfo;

    }
}
