package de.aquazen.backend.macros.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MacroNotFoundException extends RuntimeException {
    public MacroNotFoundException(String message) {
        super(message);
    }

    public MacroNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public MacroNotFoundException(Throwable cause) {
        super(cause);
    }

    public MacroNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
