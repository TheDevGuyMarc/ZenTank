package de.aquazen.backend.analoginput.controller;

import de.aquazen.backend.analoginput.domain.AnalogInput;
import de.aquazen.backend.drivers.controller.DriverDTO;
import de.aquazen.backend.drivers.domain.Pin;
import lombok.Getter;

@Getter
public class AnalogInputDTO {
    private final Long id;
    private final String name;
    private final Pin pin;
    private final boolean state;
    private final DriverDTO driver;

    public AnalogInputDTO(AnalogInput entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.pin = entity.getPin();
        this.state = entity.isState();
        this.driver = new DriverDTO(entity.getDriver());
    }
}
