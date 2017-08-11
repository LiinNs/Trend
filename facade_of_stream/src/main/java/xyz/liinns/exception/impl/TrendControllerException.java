package xyz.liinns.exception.impl;

import xyz.liinns.exception.TrendExceptionType;
import xyz.liinns.exception.annotation.TrendExceptionAt;

/**
 * Description:
 * Created by LiinNs on 2017-8-3 0003.
 */
@TrendExceptionAt(TrendExceptionType.CONTROLLER)
public final class TrendControllerException extends TrendException {

    private TrendControllerException(String message) {
        super(message);
    }

    private TrendControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    private TrendControllerException(Throwable cause) {
        super(cause);
    }

    private static TrendException raise(String message) {
        return new TrendControllerException(message);
    }

    private static TrendException raise(String message, Throwable cause) {
        return new TrendControllerException(message, cause);
    }

    private static TrendException raise(Throwable cause) {
        return new TrendControllerException(cause);
        }
}
