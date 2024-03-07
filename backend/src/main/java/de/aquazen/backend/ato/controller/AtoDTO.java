package de.aquazen.backend.ato.controller;

import de.aquazen.backend.ato.domain.Ato;
import de.aquazen.backend.equipment.controller.EquipmentDTO;
import de.aquazen.backend.inlets.controller.InletDTO;
import lombok.Getter;

@Getter
public class AtoDTO {
    private final Long id;
    private final String name;
    private final boolean alerts;
    private final int checkFrequency;
    private final String status;
    private final InletDTO inlet;
    private final EquipmentDTO equipment;

    public AtoDTO(Ato entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.alerts = entity.isAlerts();
        this.checkFrequency = entity.getCheckFrequency();
        this.status = entity.getStatus();
        this.inlet = new InletDTO(entity.getInlet());
        this.equipment = new EquipmentDTO(entity.getEquipment());
    }
}
