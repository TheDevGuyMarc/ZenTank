package de.aquazen.backend.timer.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TimerInvalidRangeException extends RuntimeException {
    public TimerInvalidRangeException(String message) {
        super(message);
    }

    public TimerInvalidRangeException(String message, Throwable cause) {
        super(message, cause);
    }

    public TimerInvalidRangeException(Throwable cause) {
        super(cause);
    }

    public TimerInvalidRangeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
