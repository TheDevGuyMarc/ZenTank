package de.aquazen.backend.equipment.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EquipmentNotFoundException extends RuntimeException {
    public EquipmentNotFoundException(String message) {
        super(message);
    }

    public EquipmentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EquipmentNotFoundException(Throwable cause) {
        super(cause);
    }

    public EquipmentNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
