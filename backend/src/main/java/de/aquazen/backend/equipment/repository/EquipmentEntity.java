package de.aquazen.backend.equipment.repository;

import de.aquazen.backend.equipment.domain.Equipment;
import de.aquazen.backend.outlets.repository.OutletEntity;
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

    @OneToOne(mappedBy = "equipment", cascade = CascadeType.ALL)
    private OutletEntity outlet;

    public EquipmentEntity(Equipment entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.state = entity.isState();
        this.outlet = new OutletEntity(entity.getOutlet());
    }
}
