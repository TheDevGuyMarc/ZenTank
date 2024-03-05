package de.aquazen.backend.ato.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AtoNotFoundException extends RuntimeException {
    public AtoNotFoundException(String message) {
        super(message);
    }

    public AtoNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AtoNotFoundException(Throwable cause) {
        super(cause);
    }

    public AtoNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
