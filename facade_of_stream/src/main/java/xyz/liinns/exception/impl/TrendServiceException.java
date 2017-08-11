package xyz.liinns.exception.impl;

import xyz.liinns.exception.TrendExceptionType;
import xyz.liinns.exception.annotation.TrendExceptionAt;


/**
 * Description:
 * Created by LiinNs on 2017-8-3 0003.
 */
@TrendExceptionAt(TrendExceptionType.SERVICE)
public final class TrendServiceException extends TrendException {

    private TrendServiceException(String message) {
        super(message);
    }

    private TrendServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    private TrendServiceException(Throwable cause) {
        super(cause);
    }

    private static TrendException raise(String message) {
        return new TrendServiceException(message);
    }

    private static TrendException raise(String message, Throwable cause) {
        return new TrendServiceException(message, cause);
    }

    private static TrendException raise(Throwable cause) {
        return new TrendServiceException(cause);
    }

}
