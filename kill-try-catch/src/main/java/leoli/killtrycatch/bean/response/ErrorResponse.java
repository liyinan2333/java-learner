package leoli.killtrycatch.bean.response;

/**
 * <p>错误返回结果</p>
 *
 * @author leoli
 * @date 2020/10/12
 */
public class ErrorResponse extends BaseResponse {

    public ErrorResponse() {
    }

    public ErrorResponse(int code, String message) {
        super(code, message);
    }
}
