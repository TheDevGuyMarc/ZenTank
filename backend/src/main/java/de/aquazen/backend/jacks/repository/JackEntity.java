package de.aquazen.backend.jacks.repository;

import de.aquazen.backend.dosing.repository.DosingEntity;
import de.aquazen.backend.drivers.domain.Pin;
import de.aquazen.backend.drivers.repository.DriverEntity;
import de.aquazen.backend.jacks.domain.Jack;
import de.aquazen.backend.lighting.repository.LightingEntity;
import de.aquazen.backend.waves.repository.WaveEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "jacks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ElementCollection
    private List<Pin> pinMap;

    @Column
    private boolean reverse;

    @Column
    private boolean state;

    @ManyToOne
    @JoinColumn(name = "drivers_id", referencedColumnName = "id")
    private DriverEntity driver;

    @OneToOne(mappedBy = "jack")
    private LightingEntity light;

    @OneToOne(mappedBy = "jack")
    private WaveEntity wave;

    @OneToOne(mappedBy = "jack")
    private DosingEntity dosing;

    /* TODO: Implement the relation to what ever equipment is needed here (Object ?) */

    public JackEntity(Jack entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.pinMap = entity.getPinMap();
        this.reverse = entity.isReverse();
        this.state = entity.isState();
        this.driver = new DriverEntity(entity.getDriver());
        this.light = new LightingEntity(entity.getLight());
        this.wave = new WaveEntity(entity.getWave());
        this.dosing = new DosingEntity(entity.getDosing());
    }
}
