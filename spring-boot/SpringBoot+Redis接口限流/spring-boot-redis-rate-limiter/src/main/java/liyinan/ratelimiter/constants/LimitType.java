package liyinan.ratelimiter.constants;

/**
 * @author liyinan2333
 * @date 2022/06/15
 */
public enum LimitType {
    /**
     * 默认策略全局限流
     */
    DEFAULT,
    /**
     * 根据请求者IP进行限流
     */
    IP
}