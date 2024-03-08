package de.aquazen.backend.jacks.domain;

import de.aquazen.backend.drivers.domain.Driver;
import de.aquazen.backend.drivers.domain.Pin;
import de.aquazen.backend.jacks.repository.JackEntity;
import de.aquazen.backend.lighting.domain.Lighting;
import de.aquazen.backend.waves.domain.Wave;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Jack {
    private Long id;
    private String name;
    private List<Pin> pinMap;
    private boolean reverse;
    private boolean state;
    private Driver driver;
    private Lighting light;
    private Wave wave;

    /* TODO: Implement the relation to what ever equipment is needed here (Object ?) */

    public Jack(JackEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.pinMap = entity.getPinMap();
        this.reverse = entity.isReverse();
        this.state = entity.isState();
        this.driver = new Driver(entity.getDriver());
        this.light = new Lighting(entity.getLight());
        this.wave = new Wave(entity.getWave());
    }
}
