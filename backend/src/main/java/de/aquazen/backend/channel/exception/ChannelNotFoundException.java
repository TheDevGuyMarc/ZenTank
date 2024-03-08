package de.aquazen.backend.channel.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ChannelNotFoundException extends RuntimeException {
    public ChannelNotFoundException(String message) {
        super(message);
    }

    public ChannelNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChannelNotFoundException(Throwable cause) {
        super(cause);
    }

    public ChannelNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
