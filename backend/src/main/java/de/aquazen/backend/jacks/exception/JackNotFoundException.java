package de.aquazen.backend.jacks.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class JackNotFoundException extends RuntimeException {
    public JackNotFoundException(String message) {
        super(message);
    }

    public JackNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public JackNotFoundException(Throwable cause) {
        super(cause);
    }

    public JackNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
