package de.aquazen.backend.waves.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class WaveNotFoundException extends RuntimeException {
    public WaveNotFoundException(String message) {
        super(message);
    }

    public WaveNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public WaveNotFoundException(Throwable cause) {
        super(cause);
    }

    public WaveNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
