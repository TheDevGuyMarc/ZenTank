package de.aquazen.backend.drivers.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DriverNotAvailableException extends RuntimeException {
    public DriverNotAvailableException(String message) {
        super(message);
    }

    public DriverNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public DriverNotAvailableException(Throwable cause) {
        super(cause);
    }

    public DriverNotAvailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
