package de.aquazen.backend.outlets.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OutletNotMappedException extends RuntimeException {
    public OutletNotMappedException(String message) {
        super(message);
    }

    public OutletNotMappedException(String message, Throwable cause) {
        super(message, cause);
    }

    public OutletNotMappedException(Throwable cause) {
        super(cause);
    }

    public OutletNotMappedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
