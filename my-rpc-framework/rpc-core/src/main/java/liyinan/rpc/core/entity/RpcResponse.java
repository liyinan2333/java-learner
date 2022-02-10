package liyinan.rpc.core.entity;

import lombok.Data;

/**
 * @author liyinan2333
 * @date 2022/2/10
 */
@Data
public class RpcResponse {

    private int code;

    private Object result;
}