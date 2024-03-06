package de.aquazen.backend.outlets.repository;

import de.aquazen.backend.drivers.domain.Pin;
import de.aquazen.backend.drivers.repository.DriverEntity;
import de.aquazen.backend.equipment.repository.EquipmentEntity;
import de.aquazen.backend.outlets.domain.Outlet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "outlets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OutletEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Pin pin;

    @Column
    private boolean reverse;

    @Column
    private boolean state;

    @ManyToOne
    @JoinColumn(name = "drivers_id", referencedColumnName = "id")
    private DriverEntity driver;

    @OneToOne
    @JoinColumn(name = "equipments_id", referencedColumnName = "id")
    private EquipmentEntity equipment;

    public OutletEntity(Outlet entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.pin = entity.getPin();
        this.reverse = entity.isReverse();
        this.state = entity.isState();
        this.driver = new DriverEntity(entity.getDriver());
        this.equipment = new EquipmentEntity(entity.getEquipment());
    }
}
