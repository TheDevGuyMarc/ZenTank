package de.aquazen.backend.errors.domain;

import de.aquazen.backend.errors.repository.ErrorEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Error {
    private Long id;
    private String message;
    private Date time;
    private int count;

    public Error(ErrorEntity entity) {
        this.id = entity.getId();
        this.message = entity.getMessage();
        this.time = entity.getTime();
        this.count = entity.getCount();
    }
}
