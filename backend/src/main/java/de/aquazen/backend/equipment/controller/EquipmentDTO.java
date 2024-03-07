package de.aquazen.backend.equipment.controller;

import de.aquazen.backend.equipment.domain.Equipment;
import de.aquazen.backend.outlets.controller.OutletDTO;
import de.aquazen.backend.temperature.controller.TemperatureDTO;
import lombok.Getter;

@Getter
public class EquipmentDTO {
    private final Long id;
    private final String name;
    private final boolean state;
    private final String type;
    private final OutletDTO outlet;
    private final TemperatureDTO cooler;
    private final TemperatureDTO heater;

    public EquipmentDTO(Equipment entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.state = entity.isState();
        this.type = entity.getType();
        this.outlet = new OutletDTO(entity.getOutlet());
        this.cooler = new TemperatureDTO(entity.getCooler());
        this.heater = new TemperatureDTO(entity.getHeater());
    }
}
