package de.aquazen.backend.errors.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ErrorNotFoundException extends RuntimeException {
    public ErrorNotFoundException(String message) {
        super(message);
    }

    public ErrorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorNotFoundException(Throwable cause) {
        super(cause);
    }

    public ErrorNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
