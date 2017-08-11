package xyz.liinns.exception.impl;

/**
 * Description:
 * Created by LiinNs on 2017-8-3 0003.
 */
public abstract class TrendException extends RuntimeException {

    TrendException() {
        super();
    }

    TrendException(String message) {
        super(message);
    }

    TrendException(String message, Throwable cause) {
        super(message, cause);
    }

    TrendException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return this.getMessage();
    }
}
