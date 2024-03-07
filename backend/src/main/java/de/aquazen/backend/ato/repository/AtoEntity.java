package de.aquazen.backend.ato.repository;

import de.aquazen.backend.ato.domain.Ato;
import de.aquazen.backend.equipment.repository.EquipmentEntity;
import de.aquazen.backend.inlets.repository.InletEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ato_systems")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AtoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private boolean alerts;

    @Column
    private int checkFrequency;

    @Column
    private String status;

    @OneToOne(mappedBy = "ato")
    private InletEntity inlet;

    @OneToOne(mappedBy = "ato")
    private EquipmentEntity equipment;

    public AtoEntity(Ato entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.alerts = entity.isAlerts();
        this.checkFrequency = entity.getCheckFrequency();
        this.status = entity.getStatus();
        this.inlet = new InletEntity(entity.getInlet());
        this.equipment = new EquipmentEntity(entity.getEquipment());
    }
}
