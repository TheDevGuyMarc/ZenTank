package de.aquazen.backend.drivers.domain;

import de.aquazen.backend.drivers.repository.DriverEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Driver {
    private Long id;
    private String name;
    private List<Pin> pinMap;
    private String type;

    public Driver(DriverEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.pinMap = entity.getPinMap();
        this.type = entity.getType();
    }
}
