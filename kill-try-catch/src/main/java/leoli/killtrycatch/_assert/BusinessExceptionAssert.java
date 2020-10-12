package leoli.killtrycatch._assert;

import leoli.killtrycatch.constant.IResponseEnum;
import leoli.killtrycatch._exception.BaseException;
import leoli.killtrycatch._exception.BusinessException;

import java.text.MessageFormat;

/**
 * @author leoli
 * @date 2020/10/12
 */
public interface BusinessExceptionAssert extends IResponseEnum, Assert {

    @Override
    default BaseException newException(Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new BusinessException(this, args, msg);
    }

    @Override
    default BaseException newException(Throwable t, Object... args) {
        String msg = MessageFormat.format(this.getMessage(), args);

        return new BusinessException(this, args, msg, t);
    }

}