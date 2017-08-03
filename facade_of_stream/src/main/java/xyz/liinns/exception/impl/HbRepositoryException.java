package xyz.liinns.exception.impl;


import xyz.liinns.exception.HbExceptionType;
import xyz.liinns.exception.annotation.HbExceptionAt;

/**
 * Description:
 * Created by LiinNs on 2017-5-24 0024.
 */
public final class HbRepositoryException extends HbException {

    private HbRepositoryException(String message) {
        super(message);
    }

    private HbRepositoryException(String message, Throwable cause) {
        super(message, cause);
    }

    private HbRepositoryException(Throwable cause) {
        super(cause);
    }

    @HbExceptionAt(HbExceptionType.REPOSITORY)
    public static class HbRepositoryExceptionBuilder {

        private static HbException raise(String message) {
            return new HbRepositoryException(message);
        }

        private static HbException raise(String message, Throwable cause) {
            return new HbRepositoryException(message, cause);
        }

        private static HbException raise(Throwable cause) {
            return new HbRepositoryException(cause);
        }
    }

}
