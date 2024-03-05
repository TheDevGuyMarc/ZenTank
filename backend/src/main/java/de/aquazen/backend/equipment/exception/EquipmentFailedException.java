package de.aquazen.backend.equipment.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EquipmentFailedException extends RuntimeException {
    public EquipmentFailedException(String message) {
        super(message);
    }

    public EquipmentFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public EquipmentFailedException(Throwable cause) {
        super(cause);
    }

    public EquipmentFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
