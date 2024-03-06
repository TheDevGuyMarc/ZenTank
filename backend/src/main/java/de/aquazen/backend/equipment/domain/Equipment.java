package de.aquazen.backend.equipment.domain;

import de.aquazen.backend.equipment.repository.EquipmentEntity;
import de.aquazen.backend.outlets.domain.Outlet;
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
    private Outlet outlet;

    public Equipment(EquipmentEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.state = entity.isState();
        this.outlet = new Outlet(entity.getOutlet());
    }
}
