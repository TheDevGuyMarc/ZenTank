package de.aquazen.backend.regiment.domain;

import de.aquazen.backend.dosing.domain.Dosing;
import de.aquazen.backend.regiment.repository.RegimentEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Regiment {
    private Long id;
    private double duration;
    private double speed;
    private boolean state;

    /* TODO: implement timer relation */

    private Dosing dosing;

    public Regiment(RegimentEntity entity) {
        this.id = entity.getId();
        this.duration = entity.getDuration();
        this.speed = entity.getSpeed();
        this.state = entity.isState();
        this.dosing = new Dosing(entity.getDosing());
    }
}
