package de.aquazen.backend.steps.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class StepMalformedException extends RuntimeException {
    public StepMalformedException(String message) {
        super(message);
    }

    public StepMalformedException(String message, Throwable cause) {
        super(message, cause);
    }

    public StepMalformedException(Throwable cause) {
        super(cause);
    }

    public StepMalformedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
