package de.aquazen.backend.outlets.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OutletNotFoundException extends RuntimeException {
    public OutletNotFoundException(String message) {
        super(message);
    }

    public OutletNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public OutletNotFoundException(Throwable cause) {
        super(cause);
    }

    public OutletNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
