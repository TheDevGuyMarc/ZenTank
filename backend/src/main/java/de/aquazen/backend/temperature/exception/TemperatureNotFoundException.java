package de.aquazen.backend.temperature.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TemperatureNotFoundException extends RuntimeException {
    public TemperatureNotFoundException(String message) {
        super(message);
    }

    public TemperatureNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TemperatureNotFoundException(Throwable cause) {
        super(cause);
    }

    public TemperatureNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
