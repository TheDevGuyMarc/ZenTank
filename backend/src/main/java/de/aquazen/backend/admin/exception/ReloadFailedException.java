package de.aquazen.backend.admin.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ReloadFailedException extends RuntimeException {
    public ReloadFailedException(String message) {
        super(message);
    }

    public ReloadFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReloadFailedException(Throwable cause) {
        super(cause);
    }

    public ReloadFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
