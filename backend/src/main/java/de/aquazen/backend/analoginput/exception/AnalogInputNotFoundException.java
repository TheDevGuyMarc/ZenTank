package de.aquazen.backend.analoginput.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AnalogInputNotFoundException extends RuntimeException {
    public AnalogInputNotFoundException(String message) {
        super(message);
    }

    public AnalogInputNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AnalogInputNotFoundException(Throwable cause) {
        super(cause);
    }

    public AnalogInputNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
