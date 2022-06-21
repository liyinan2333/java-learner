package liyinan.ratelimiter.exception;

/**
 * @author liyinan2333
 * @date 2022/06/17
 */
public class LimitException extends RuntimeException {

    public LimitException(){}

    public LimitException(String message) {
        super(message);
    }

}
