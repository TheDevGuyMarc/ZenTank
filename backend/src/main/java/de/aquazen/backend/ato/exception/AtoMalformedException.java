package de.aquazen.backend.ato.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AtoMalformedException extends RuntimeException {
    public AtoMalformedException(String message) {
        super(message);
    }

    public AtoMalformedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AtoMalformedException(Throwable cause) {
        super(cause);
    }

    public AtoMalformedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
