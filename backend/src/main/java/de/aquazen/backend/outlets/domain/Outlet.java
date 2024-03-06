package de.aquazen.backend.outlets.domain;

import de.aquazen.backend.drivers.domain.Driver;
import de.aquazen.backend.drivers.domain.Pin;
import de.aquazen.backend.equipment.domain.Equipment;
import de.aquazen.backend.outlets.repository.OutletEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Outlet {
    private Long id;
    private String name;
    private Pin pin;
    private boolean reverse;
    private boolean state;
    private Driver driver;
    private Equipment equipment;

    public Outlet(OutletEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.pin = entity.getPin();
        this.reverse = entity.isReverse();
        this.state = entity.isState();
        this.driver = new Driver(entity.getDriver());
        this.equipment = new Equipment(entity.getEquipment());
    }
}
