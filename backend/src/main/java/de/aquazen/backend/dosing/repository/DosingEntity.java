package de.aquazen.backend.dosing.repository;

import de.aquazen.backend.dosing.domain.Dosing;
import de.aquazen.backend.drivers.domain.Pin;
import de.aquazen.backend.jacks.repository.JackEntity;
import de.aquazen.backend.regiment.repository.RegimentEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "dosing_systems")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DosingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Pin pin;

    @OneToOne
    @JoinColumn(name = "jack_id")
    private JackEntity jack;

    @OneToMany(mappedBy = "dosing", cascade = CascadeType.ALL)
    private List<RegimentEntity> regiments;

    public DosingEntity(Dosing entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.pin = entity.getPin();
        this.jack = new JackEntity(entity.getJack());
        this.regiments = entity.getRegiments().stream().map(RegimentEntity::new).toList();
    }
}
