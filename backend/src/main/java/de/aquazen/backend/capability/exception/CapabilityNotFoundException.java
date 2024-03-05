package de.aquazen.backend.capability.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CapabilityNotFoundException extends RuntimeException {
    public CapabilityNotFoundException(String message) {
        super(message);
    }

    public CapabilityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CapabilityNotFoundException(Throwable cause) {
        super(cause);
    }

    public CapabilityNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
