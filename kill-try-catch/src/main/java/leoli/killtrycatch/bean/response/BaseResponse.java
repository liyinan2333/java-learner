package leoli.killtrycatch.bean.response;

import leoli.killtrycatch.constant._enum.CommonResponseEnum;
import leoli.killtrycatch.constant.IResponseEnum;
import lombok.Data;

/**
 * <p>基础返回结果</p>
 *
 * @author leoli
 * @date 2020/10/12
 */
@Data
public class BaseResponse {
    /**
     * 返回码
     */
    protected int code;
    /**
     * 返回消息
     */
    protected String message;

    public BaseResponse() {
        // 默认创建成功的回应
        this(CommonResponseEnum.SUCCESS);
    }

    public BaseResponse(IResponseEnum responseEnum) {
        this(responseEnum.getCode(), responseEnum.getMessage());
    }

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
