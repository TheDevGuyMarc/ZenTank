package de.aquazen.backend.analoginput.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AnalogInputNotMappedException extends RuntimeException {
    public AnalogInputNotMappedException(String message) {
        super(message);
    }

    public AnalogInputNotMappedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AnalogInputNotMappedException(Throwable cause) {
        super(cause);
    }

    public AnalogInputNotMappedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
