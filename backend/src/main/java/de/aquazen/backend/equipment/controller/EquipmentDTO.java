package de.aquazen.backend.equipment.controller;

import de.aquazen.backend.equipment.domain.Equipment;
import de.aquazen.backend.outlets.controller.OutletDTO;
import lombok.Getter;

@Getter
public class EquipmentDTO {
    private final Long id;
    private final String name;
    private final boolean state;
    private final OutletDTO outlet;

    public EquipmentDTO(Equipment entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.state = entity.isState();
        this.outlet = new OutletDTO(entity.getOutlet());
    }
}
