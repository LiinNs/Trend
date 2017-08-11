package xyz.liinns.exception.impl;


import xyz.liinns.exception.TrendExceptionType;
import xyz.liinns.exception.annotation.TrendExceptionAt;

/**
 * Description:
 * Created by LiinNs on 2017-5-24 0024.
 */
@TrendExceptionAt(TrendExceptionType.REPOSITORY)
public final class TrendRepositoryException extends TrendException {

    private TrendRepositoryException(String message) {
        super(message);
    }

    private TrendRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }

    private TrendRepositoryException(Throwable cause) {
        super(cause);
    }

    private static TrendException raise(String message) {
        return new TrendRepositoryException(message);
    }

    private static TrendException raise(String message, Throwable cause) {
        return new TrendRepositoryException(message, cause);
    }

    private static TrendException raise(Throwable cause) {
        return new TrendRepositoryException(cause);
    }

}
