package de.aquazen.backend.inlets.domain;

import de.aquazen.backend.ato.domain.Ato;
import de.aquazen.backend.drivers.domain.Driver;
import de.aquazen.backend.drivers.domain.Pin;
import de.aquazen.backend.inlets.repository.InletEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Inlet {
    private Long id;
    private String name;
    private Pin pin;
    private boolean reverse;
    private boolean state;
    private Driver driver;
    private Ato ato;

    public Inlet(InletEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.pin = entity.getPin();
        this.reverse = entity.isReverse();
        this.state = entity.isState();
        this.driver = new Driver(entity.getDriver());
        this.ato = new Ato(entity.getAto());
    }
}
