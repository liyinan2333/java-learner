package liyinan.split.table.util;

public class IdUtil {

    /**
     * 临时解决方案，针对分库分表的主键生成，会单独分析
     * @return
     */
    public static Long getId() {
        return System.currentTimeMillis();
    }

}
