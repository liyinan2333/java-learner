package leoli.pattern.adapter.expand;

import leoli.pattern.adapter.expand.impl.IOuterUserOfficeInfo;

import java.util.HashMap;
import java.util.Map;

/**
 * 员工的工作信息，比如职位等
 *
 * @author leoli
 * @date 2020/8/22
 */
public class OuterUserOfficeInfo implements IOuterUserOfficeInfo {

    @Override
    public Map getUserOfficeInfo() {

        HashMap officeInfo = new HashMap();
        officeInfo.put("jobPosition", "这个人的职位是Boss...");
        officeInfo.put("officeTelNumber", "员工的办公电话是...");

        return officeInfo;

    }

}
