package de.aquazen.backend.equipment.domain;

import de.aquazen.backend.ato.domain.Ato;
import de.aquazen.backend.equipment.repository.EquipmentEntity;
import de.aquazen.backend.outlets.domain.Outlet;
import de.aquazen.backend.temperature.domain.Temperature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Equipment {
    private Long id;
    private String name;
    private boolean state;
    private String type;
    private Outlet outlet;
    private Temperature cooler;
    private Temperature heater;
    private Ato ato;

    public Equipment(EquipmentEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.state = entity.isState();
        this.type = entity.getType();
        this.outlet = new Outlet(entity.getOutlet());
        this.cooler = new Temperature(entity.getCooler());
        this.heater = new Temperature(entity.getHeater());
        this.ato = new Ato(entity.getAto());
    }
}
