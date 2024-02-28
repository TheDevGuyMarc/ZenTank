package de.aquazen.backend.equipment.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EquipmentNotReachableException extends RuntimeException {
    public EquipmentNotReachableException(String message) {
        super(message);
    }

    public EquipmentNotReachableException(String message, Throwable cause) {
        super(message, cause);
    }

    public EquipmentNotReachableException(Throwable cause) {
        super(cause);
    }

    public EquipmentNotReachableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
