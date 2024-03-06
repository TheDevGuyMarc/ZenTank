package de.aquazen.backend.analoginput.domain;

import de.aquazen.backend.analoginput.repository.AnalogInputEntity;
import de.aquazen.backend.drivers.domain.Driver;
import de.aquazen.backend.drivers.domain.Pin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AnalogInput {
    private Long id;
    private String name;
    private Pin pin;
    private boolean state;
    private Driver driver;

    public AnalogInput(AnalogInputEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.pin = entity.getPin();
        this.state = entity.isState();
        this.driver = new Driver(entity.getDriver());
    }
}
