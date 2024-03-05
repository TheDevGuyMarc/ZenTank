package de.aquazen.backend.jacks.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class JackNotMappedException extends RuntimeException {
    public JackNotMappedException(String message) {
        super(message);
    }

    public JackNotMappedException(String message, Throwable cause) {
        super(message, cause);
    }

    public JackNotMappedException(Throwable cause) {
        super(cause);
    }

    public JackNotMappedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
