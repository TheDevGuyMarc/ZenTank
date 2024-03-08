package de.aquazen.backend.regiment.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RegimentNotFoundException extends RuntimeException {
    public RegimentNotFoundException(String message) {
        super(message);
    }

    public RegimentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegimentNotFoundException(Throwable cause) {
        super(cause);
    }

    public RegimentNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
