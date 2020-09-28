package leoli.pattern.flyweight.extend.performance;

/**
 * 报考信息
 *
 * @author leoli
 * @date 2020/9/28
 */
public class SignInfo {

    //报名人员的ID
    private String id;
    //外部状态 考试科目、考试地点
    private ExtrinsicState extrinsicState;
    //邮寄地址
    private String postAddress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ExtrinsicState getExtrinsicState() {
        return extrinsicState;
    }

    public void setExtrinsicState(ExtrinsicState extrinsicState) {
        this.extrinsicState = extrinsicState;
    }

    public String getPostAddress() {
        return postAddress;
    }

    public void setPostAddress(String postAddress) {
        this.postAddress = postAddress;
    }
}