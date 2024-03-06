package de.aquazen.backend.errors.controller;

import de.aquazen.backend.errors.domain.Error;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ErrorDTO {
    private final Long id;
    private final String message;
    private final Date time;
    private final int count;

    public ErrorDTO(Error entity) {
        this.id = entity.getId();
        this.message = entity.getMessage();
        this.time = entity.getTime();
        this.count = entity.getCount();
    }
}
