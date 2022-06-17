package liyinan.ratelimiter.exception;

/**
 * @author liyinan2333
 * @date 2022/06/17
 */
public class ServiceException extends Exception {

    public ServiceException(){}

    public ServiceException(String message) {
        super(message);
    }

}
