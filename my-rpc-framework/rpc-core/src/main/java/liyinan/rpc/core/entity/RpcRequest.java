package liyinan.rpc.core.entity;

import lombok.Data;

/**
 * @author liyinan2333
 * @date 2022/2/10
 */
@Data
public class RpcRequest {

    private String  methodName;

    private String className;

    private Class[] paramType;

    private Object[] args;
}