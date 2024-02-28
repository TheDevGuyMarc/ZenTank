package de.aquazen.backend.inlets.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InletNotMappedException extends RuntimeException {
    public InletNotMappedException(String message) {
        super(message);
    }

    public InletNotMappedException(String message, Throwable cause) {
        super(message, cause);
    }

    public InletNotMappedException(Throwable cause) {
        super(cause);
    }

    public InletNotMappedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
