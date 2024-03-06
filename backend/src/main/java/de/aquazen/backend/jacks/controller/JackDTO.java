package de.aquazen.backend.jacks.controller;

import de.aquazen.backend.drivers.controller.DriverDTO;
import de.aquazen.backend.drivers.domain.Pin;
import de.aquazen.backend.jacks.domain.Jack;
import lombok.Getter;

import java.util.List;

@Getter
public class JackDTO {
    private final Long id;
    private final String name;
    private final List<Pin> pinMap;
    private final boolean reverse;
    private final boolean state;
    private final DriverDTO driver;

    /* TODO: Implement the relation to what ever equipment is needed here (Object ?) */

    public JackDTO(Jack entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.pinMap = entity.getPinMap();
        this.reverse = entity.isReverse();
        this.state = entity.isState();
        this.driver = new DriverDTO(entity.getDriver());
    }
}
