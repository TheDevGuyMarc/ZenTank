package de.aquazen.backend.misting.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MistingNotFoundException extends RuntimeException {
    public MistingNotFoundException(String message) {
        super(message);
    }

    public MistingNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MistingNotFoundException(Throwable cause) {
        super(cause);
    }

    public MistingNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
