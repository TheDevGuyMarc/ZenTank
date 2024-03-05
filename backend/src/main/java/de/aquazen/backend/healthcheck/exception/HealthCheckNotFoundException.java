package de.aquazen.backend.healthcheck.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HealthCheckNotFoundException extends RuntimeException {
    public HealthCheckNotFoundException(String message) {
        super(message);
    }

    public HealthCheckNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public HealthCheckNotFoundException(Throwable cause) {
        super(cause);
    }

    public HealthCheckNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
