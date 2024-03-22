package it.sponzi.gamma.common.exception;

import java.util.function.Supplier;

public class InternalException extends RuntimeException implements Supplier<InternalException> {

    public InternalException(String message, Throwable cause){
        super(message,cause);
    }

    public InternalException(String message) {
        super(message);
    }

    @Override
    public InternalException get() {
        return this;
    }
}
