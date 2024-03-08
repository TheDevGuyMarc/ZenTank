package de.aquazen.backend.jacks.controller;

import de.aquazen.backend.dosing.controller.DosingDTO;
import de.aquazen.backend.dosing.domain.Dosing;
import de.aquazen.backend.drivers.controller.DriverDTO;
import de.aquazen.backend.drivers.domain.Pin;
import de.aquazen.backend.jacks.domain.Jack;
import de.aquazen.backend.lighting.controller.LightingDTO;
import de.aquazen.backend.waves.controller.WaveDTO;
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
    private final LightingDTO light;
    private final WaveDTO wave;
    private final DosingDTO dosing;

    /* TODO: Implement the relation to what ever equipment is needed here (Object ?) */

    public JackDTO(Jack entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.pinMap = entity.getPinMap();
        this.reverse = entity.isReverse();
        this.state = entity.isState();
        this.driver = new DriverDTO(entity.getDriver());
        this.light = new LightingDTO(entity.getLight());
        this.wave = new WaveDTO(entity.getWave());
        this.dosing = new DosingDTO(entity.getDosing());
    }
}
