package de.aquazen.backend.equipment.repository;

import de.aquazen.backend.equipment.domain.Equipment;
import de.aquazen.backend.outlets.repository.OutletEntity;
import de.aquazen.backend.temperature.repository.TemperatureEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "equipments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private boolean state;

    @Column
    private String type;

    @OneToOne(mappedBy = "equipment", cascade = CascadeType.ALL)
    private OutletEntity outlet;

    @OneToOne
    @JoinColumn(name = "cooler_temperature_id")
    private TemperatureEntity cooler;

    @OneToOne
    @JoinColumn(name = "heater_temperature_id")
    private TemperatureEntity heater;

    public EquipmentEntity(Equipment entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.state = entity.isState();
        this.type = entity.getType();
        this.outlet = new OutletEntity(entity.getOutlet());
        this.cooler = new TemperatureEntity(entity.getCooler());
        this.heater = new TemperatureEntity(entity.getHeater());
    }
}
