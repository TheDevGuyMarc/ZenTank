package de.aquazen.backend.regiment.controller;

import de.aquazen.backend.dosing.controller.DosingDTO;
import de.aquazen.backend.regiment.domain.Regiment;
import lombok.Getter;

@Getter
public class RegimentDTO {
    private final Long id;
    private final double duration;
    private final double speed;
    private final boolean state;

    /* TODO: implement timer relation */

    private final DosingDTO dosing;

    public RegimentDTO(Regiment entity) {
        this.id = entity.getId();
        this.duration = entity.getDuration();
        this.speed = entity.getSpeed();
        this.state = entity.isState();
        this.dosing = new DosingDTO(entity.getDosing());
    }
}
