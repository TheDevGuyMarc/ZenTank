package de.aquazen.backend.admin.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RebootFailedException extends RuntimeException {
    public RebootFailedException(String message) {
        super(message);
    }

    public RebootFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public RebootFailedException(Throwable cause) {
        super(cause);
    }

    public RebootFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
