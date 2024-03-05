package de.aquazen.backend.lighting.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LightingNotFoundException extends RuntimeException {
    public LightingNotFoundException(String message) {
        super(message);
    }

    public LightingNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public LightingNotFoundException(Throwable cause) {
        super(cause);
    }

    public LightingNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
