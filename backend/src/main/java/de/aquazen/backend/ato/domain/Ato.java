package de.aquazen.backend.ato.domain;

import de.aquazen.backend.ato.repository.AtoEntity;
import de.aquazen.backend.equipment.domain.Equipment;
import de.aquazen.backend.inlets.domain.Inlet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Ato {
    private Long id;
    private String name;
    private boolean alerts;
    private int checkFrequency;
    private String status;
    private Inlet inlet;
    private Equipment equipment;

    public Ato(AtoEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.alerts = entity.isAlerts();
        this.checkFrequency = entity.getCheckFrequency();
        this.status = entity.getStatus();
        this.inlet = new Inlet(entity.getInlet());
        this.equipment = new Equipment(entity.getEquipment());
    }
}
