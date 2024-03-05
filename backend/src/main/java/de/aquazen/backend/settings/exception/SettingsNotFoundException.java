package de.aquazen.backend.settings.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SettingsNotFoundException extends RuntimeException {
    public SettingsNotFoundException(String message) {
        super(message);
    }

    public SettingsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SettingsNotFoundException(Throwable cause) {
        super(cause);
    }

    public SettingsNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
