package de.aquazen.backend.admin.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PowerOffFailedException extends RuntimeException {
    public PowerOffFailedException(String message) {
        super(message);
    }

    public PowerOffFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PowerOffFailedException(Throwable cause) {
        super(cause);
    }

    public PowerOffFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
