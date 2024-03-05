package de.aquazen.backend.drivers.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DriverNotFoundException extends RuntimeException {
    public DriverNotFoundException(String message) {
        super(message);
    }

    public DriverNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DriverNotFoundException(Throwable cause) {
        super(cause);
    }

    public DriverNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
