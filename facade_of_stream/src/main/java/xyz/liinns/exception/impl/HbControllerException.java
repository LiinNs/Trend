package xyz.liinns.exception.impl;

import xyz.liinns.exception.HbExceptionType;
import xyz.liinns.exception.annotation.HbExceptionAt;

/**
 * Description:
 * Created by LiinNs on 2017-8-3 0003.
 */
public final class HbControllerException extends HbException {

    private HbControllerException(String message) {
        super(message);
    }

    private HbControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    private HbControllerException(Throwable cause) {
        super(cause);
    }

    @HbExceptionAt(HbExceptionType.CONTROLLER)
    public static class HbControllerExceptionBuilder {

        private static HbException raise(String message) {
            return new HbControllerException(message);
        }

        private static HbException raise(String message, Throwable cause) {
            return new HbControllerException(message, cause);
        }

        private static HbException raise(Throwable cause) {
            return new HbControllerException(cause);
        }
    }
}
