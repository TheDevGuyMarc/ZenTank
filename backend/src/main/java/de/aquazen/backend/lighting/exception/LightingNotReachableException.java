package de.aquazen.backend.lighting.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LightingNotReachableException extends RuntimeException {
    public LightingNotReachableException(String message) {
        super(message);
    }

    public LightingNotReachableException(String message, Throwable cause) {
        super(message, cause);
    }

    public LightingNotReachableException(Throwable cause) {
        super(cause);
    }

    public LightingNotReachableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
