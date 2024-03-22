package it.sponzi.gamma.common.exception;

import java.util.function.Supplier;

public class EnumNotFoundException  extends RuntimeException implements Supplier<EnumNotFoundException> {

    public EnumNotFoundException(String message, Throwable cause){
        super(message + " is not a recognized enum",cause);
    }

    public EnumNotFoundException(String message) {
        super(message + " is not a recognized enum");
    }

    @Override
    public EnumNotFoundException get() {
        return this;
    }
}
