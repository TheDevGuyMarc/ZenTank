package de.aquazen.backend.dosing.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DosingNotFoundException extends RuntimeException {
    public DosingNotFoundException(String message) {
        super(message);
    }

    public DosingNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DosingNotFoundException(Throwable cause) {
        super(cause);
    }

    public DosingNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
