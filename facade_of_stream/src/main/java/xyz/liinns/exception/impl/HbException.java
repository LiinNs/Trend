package xyz.liinns.exception.impl;

/**
 * Description:
 * Created by LiinNs on 2017-8-3 0003.
 */
public abstract class HbException extends RuntimeException {

    HbException() {
        super();
    }

    HbException(String message) {
        super(message);
    }

    HbException(String message, Throwable cause) {
        super(message, cause);
    }

    HbException(Throwable cause) {
        super(cause);
    }

    @Override
    public String toString() {
        return this.getMessage();
    }
}
