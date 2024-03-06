package de.aquazen.backend.drivers.repository;

import de.aquazen.backend.analoginput.repository.AnalogInputEntity;
import de.aquazen.backend.drivers.domain.Driver;
import de.aquazen.backend.drivers.domain.Pin;
import de.aquazen.backend.inlets.repository.InletEntity;
import de.aquazen.backend.jacks.repository.JackEntity;
import de.aquazen.backend.outlets.repository.OutletEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "drivers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DriverEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ElementCollection
    private List<Pin> pinMap;

    @Column
    private String type;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<OutletEntity> outlets;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<InletEntity> inlets;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<JackEntity> jacks;

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<AnalogInputEntity> analogInputs;

    public DriverEntity(Driver entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.pinMap = entity.getPinMap();
        this.type = entity.getType();
        this.outlets = entity.getOutlets().stream().map(OutletEntity::new).toList();
        this.inlets = entity.getInlets().stream().map(InletEntity::new).toList();
        this.jacks = entity.getJacks().stream().map(JackEntity::new).toList();
        this.analogInputs = entity.getAnalogInputs().stream().map(AnalogInputEntity::new).toList();
    }
}
