package leoli.pattern.adapter.expand;

import leoli.pattern.adapter.expand.impl.IOuterUserBaseInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户的基本信息
 *
 * @author leoli
 * @date 2020/8/22
 */
public class OuterUserBaseInfo implements IOuterUserBaseInfo {

    @Override
    public Map getUserBaseInfo() {

        HashMap baseInfoMap = new HashMap();
        baseInfoMap.put("userName", "这个员工叫混世魔王...");
        baseInfoMap.put("mobileNumber", "这个员工电话是...");
        return baseInfoMap;

    }
}
