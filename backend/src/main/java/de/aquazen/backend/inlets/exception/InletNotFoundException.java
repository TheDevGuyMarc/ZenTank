package de.aquazen.backend.inlets.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InletNotFoundException extends RuntimeException {
    public InletNotFoundException(String message) {
        super(message);
    }

    public InletNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public InletNotFoundException(Throwable cause) {
        super(cause);
    }

    public InletNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
