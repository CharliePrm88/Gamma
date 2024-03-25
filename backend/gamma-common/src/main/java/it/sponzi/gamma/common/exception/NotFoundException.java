package it.sponzi.gamma.common.exception;

public class NotFoundException extends InternalException {

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(String message) {
        super(message);
    }
}
