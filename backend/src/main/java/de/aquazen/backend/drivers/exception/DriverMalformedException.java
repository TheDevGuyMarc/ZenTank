package de.aquazen.backend.drivers.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DriverMalformedException extends RuntimeException {
    public DriverMalformedException(String message) {
        super(message);
    }

    public DriverMalformedException(String message, Throwable cause) {
        super(message, cause);
    }

    public DriverMalformedException(Throwable cause) {
        super(cause);
    }

    public DriverMalformedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
