package xyz.liinns.exception.impl;

import xyz.liinns.exception.HbExceptionType;
import xyz.liinns.exception.annotation.HbExceptionAt;


/**
 * Description:
 * Created by LiinNs on 2017-8-3 0003.
 */
public final class HbServiceException extends HbException {

    private HbServiceException(String message) {
        super(message);
    }

    private HbServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    private HbServiceException(Throwable cause) {
        super(cause);
    }

    @HbExceptionAt(HbExceptionType.SERVICE)
    public static class HbServiceExceptionBuilder {

        private static HbException raise(String message) {
            return new HbServiceException(message);
        }

        private static HbException raise(String message, Throwable cause) {
            return new HbServiceException(message, cause);
        }

        private static HbException raise(Throwable cause) {
            return new HbServiceException(cause);
        }
    }

}
