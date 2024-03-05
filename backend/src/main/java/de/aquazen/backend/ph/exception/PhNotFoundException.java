package de.aquazen.backend.ph.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PhNotFoundException extends RuntimeException {
    public PhNotFoundException(String message) {
        super(message);
    }

    public PhNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PhNotFoundException(Throwable cause) {
        super(cause);
    }

    public PhNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
