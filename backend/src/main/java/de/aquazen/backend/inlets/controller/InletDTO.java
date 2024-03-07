package de.aquazen.backend.inlets.controller;

import de.aquazen.backend.ato.controller.AtoDTO;
import de.aquazen.backend.drivers.controller.DriverDTO;
import de.aquazen.backend.drivers.domain.Pin;
import de.aquazen.backend.inlets.domain.Inlet;
import lombok.Getter;

@Getter
public class InletDTO {
    private final Long id;
    private final String name;
    private final Pin pin;
    private final boolean reverse;
    private final boolean state;
    private final DriverDTO driver;
    private final AtoDTO ato;

    public InletDTO(Inlet entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.pin = entity.getPin();
        this.reverse = entity.isReverse();
        this.state = entity.isState();
        this.driver = new DriverDTO(entity.getDriver());
        this.ato = new AtoDTO(entity.getAto());
    }
}
