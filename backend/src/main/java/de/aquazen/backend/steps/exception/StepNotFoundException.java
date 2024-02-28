package de.aquazen.backend.steps.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StepNotFoundException extends RuntimeException {
    public StepNotFoundException(String message) {
        super(message);
    }

    public StepNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StepNotFoundException(Throwable cause) {
        super(cause);
    }

    public StepNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
